class KthLargest {


// nums : [1,2,3,3,4]
// [1,2,3,3]
// k : 4 
    private final PriorityQueue<Integer> pq;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        // 오름차순 힙 
        pq = new PriorityQueue<>();

        for (int num : nums){
            pq.offer(num);
            if (pq.size() > k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}
