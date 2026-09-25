class Twitter {

    // time 이 더큰 tweet 을 maxheap 으로 관리
    // k way merge 방식 
    // 좋은 문제다...

    private final Map<Integer, Set<Integer>> fmap;
    private final Map<Integer, List<int[]>> tmap;
    private int time;

    public Twitter() {
       this.time = 0;
       fmap = new HashMap<>();
       tmap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
       tmap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{time++, tweetId});
    }
    
    // 자신의 피드에서 가장 최근 트윗 10개 조회
    // 각 트윗은, 사용자가 팔로우하고 있는 사용자의 것
    // 혹은 본인이 게시한 것이어야 함. 
    // 정렬 기준은 최근 것부터 오름차순 
    public List<Integer> getNewsFeed(int userId) {

       List<Integer> res = new ArrayList<>();
       
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
       Set<Integer> candidates = new HashSet<>(fmap.getOrDefault(userId, new HashSet<>()));

       candidates.add(userId);

       for (int fId : candidates){

            if (tmap.containsKey(fId)){
                List<int[]> tweets = tmap.get(fId);
                int index = tweets.size() - 1;
                
                int[] tweet = tweets.get(index);
                pq.offer(new int[]{tweet[0], tweet[1], fId, index});  
            }
       }

       while(!pq.isEmpty() && res.size() < 10){
        int[] cur = pq.poll();
        res.add(cur[1]);
        int index = cur[3];
        
        // 첫번째 트윗이 아닌 이상 계속 넣어야됨. 
        if (index > 0){
            int[] tweet = tmap.get(cur[2]).get(index - 1);
            pq.offer(new int[]{tweet[0], tweet[1], cur[2], index - 1});
        }
       }
       
       return res;
       
       
    }
    
    // follower -> followee 팔로우 
    public void follow(int followerId, int followeeId) {
      fmap.computeIfAbsent(followerId, 
      k -> new HashSet<>()).add(followeeId);
    }
    
    // follower -> followee 해제. 
    public void unfollow(int followerId, int followeeId) {
      Set<Integer> set = fmap.getOrDefault(followerId, new HashSet<>());

      set.remove(Integer.valueOf(followeeId));
    }
}
