class Twitter {

    // 신경 써야할 것
    // 1. feed List 를 복사본으로 만드는 것 
    // 2. 피드 조회할때, add 가 아닌 addAll 을 사용해야한다는 것 

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
        
        // 본인 피드 조회
        List<int[]> feed = new ArrayList<>(tmap.getOrDefault(userId, 
        new ArrayList<>()));

        for (int followeeId : fmap.getOrDefault(userId, new HashSet<>())){
            feed.addAll(tmap.getOrDefault(
                followeeId, new ArrayList<>()
            ));

        }

        feed.sort((a,b) -> b[0] - a[0]);

        List<Integer> res = new ArrayList<>();
        for (int i = 0 ; i < Math.min(10, feed.size()); i++){
            res.add(feed.get(i)[1]);
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
