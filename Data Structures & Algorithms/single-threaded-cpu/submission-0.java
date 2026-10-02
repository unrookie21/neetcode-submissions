class Solution {

    public class Process implements Comparable<Process>{

        public int number;
        public int processingTime;

        public Process(int n, int p){
            this.number = n;
            this.processingTime = p;
        }

        @Override
        public int compareTo(Process other){
            if (this.processingTime == other.processingTime){
                return number - other.number;
            }

            return processingTime - other.processingTime;
        }

    }
    public int[] getOrder(int[][] tasks) {

        int taskNumber = tasks.length;
        int[] order = new int[taskNumber];

        int[][] sorted = new int[taskNumber][3];

        for (int i = 0; i < taskNumber; i++){
            sorted[i][0] = tasks[i][0];
            sorted[i][1] = tasks[i][1];
            sorted[i][2] = i;
        }
        
        // 도달시간이 빠른순서대로 정렬 
        Arrays.sort(sorted, (a,b) -> a[0] - b[0]);

        Queue<Process> pq = new PriorityQueue<>();
        int done = 0;
        int curTime = 0;
        int idx = 0; 
        // 모든 프로세스가 완료되기전까지 반복 
        while (done < taskNumber){

            // curTime 보다 작거나 같은 작업들을 추가한다.
            while (idx < sorted.length && sorted[idx][0] <= curTime){
                pq.offer(new Process(sorted[idx][2], sorted[idx][1]));
                idx++;
            }

            if (pq.isEmpty()){
                curTime = sorted[idx][0];
                continue;
            }

            Process process = pq.poll();
            curTime += process.processingTime;
            order[done++] = process.number;


        }

        return order;

        







    

        
    }
}