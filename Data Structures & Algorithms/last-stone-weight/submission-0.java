class Solution {
    public int lastStoneWeight(int[] stones) {
        // 가장 무거운 두 돌 선택
        // x == y -> 둘다 파괴
        // x < y -> x 파괴, y 는 y -x 

        // 남은 돌이 하나 이하가 될때까지 시뮬 반복

        // 마지막으로 남은 돌의 무게 반환.
        // 남은 돌 없으면 0 반환
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int w : stones){
            pq.offer(w);
        }

        // 시뮬 반복 
        while (pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();

            if (x == y) continue;

            if (x < y){
                // x 파괴
                pq.offer(y - x);
            }

            if (x > y){
                pq.offer(x - y);
            }
        }

        if (pq.size() == 0) return 0;
        return pq.peek();
        
    }
}
