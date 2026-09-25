class KthLargest {


// nums : [8,5,7,2]
// k : 3

// minHeap 을 만들고, size k 초과하면 heap 에서 빼버림.
// 왜냐, 필요없는 수이기 때문. -> 우리는 k번째 큰 수를 알기를 
// 원하니까.
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
