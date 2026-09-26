class Solution {
    public int findKthLargest(int[] nums, int k) {

        // k = 3 , [2, 3, 1, 1, 5, 5, 4]
        // [2] 
        // [2,3]
        // [1,2,3]
        // [3,5,5]
        // [4,5,5]

        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : nums){
            pq.offer(num);
            if (pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
