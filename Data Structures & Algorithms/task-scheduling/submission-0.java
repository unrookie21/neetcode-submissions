class Solution {
    public int leastInterval(char[] tasks, int n) {

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int[] count = new int[26];

        for (char task : tasks){
            count[task - 'A']++;
        }

        for (int num : count){
            if (num > 0){
                pq.offer(num);
            }
        }
        int time = 0;
        // pq : [3,1,1]
        while (!pq.isEmpty()){

            int cycle = n + 1;
            int done = 0;

            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < cycle && !pq.isEmpty(); i++){
                int cur = pq.poll();
                if (cur > 1){
                    temp.add(cur - 1);
                }
                done++;

            }
            // done 은 현재 3인상태
            // [2]
            // pq 가 비어있음 -> 작업 끝. 실제 수행한 작업 만큼 시간 더함
            // pq 가 비어있지 않음 -> 아직 덩어리가 남음. cycle 만큼 시간 더함
            
            pq.addAll(temp);
            time += pq.isEmpty() ? done : cycle;
            
        }

        return time;
        
    }
}
