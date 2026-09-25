class Twitter {

    private int time;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        time = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k-> new ArrayList<>()).add(new int[]{time++, tweetId});

    }
    
    // 자신의 피드에서 가장 최근 트윗 10개 조회
    // 각 트윗은, 사용자가 팔로우하고 있는 사용자의 것
    // 혹은 본인이 게시한 것이어야 함. 
    // 정렬 기준은 최근 것부터 오름차순 
    public List<Integer> getNewsFeed(int userId) {
        
    List<int[]> feed = new ArrayList<>  (tweetMap.getOrDefault(userId, new ArrayList<>()));

    for (int followeeId : 
    followMap.getOrDefault(userId, new HashSet<>())){

        feed.addAll(tweetMap.getOrDefault(
            followeeId, new ArrayList<>()));
    }

    feed.sort((a,b) -> b[0] - a[0]);
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < Math.min(10, feed.size()); i++){
        res.add(feed.get(i)[1]);
    }
    return res;

    }
    
    // follower -> followee 팔로우 
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    // follower -> followee 해제. 
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = followMap.getOrDefault(followerId, new HashSet<>());

followees.remove(Integer.valueOf(followeeId));
    }
}
