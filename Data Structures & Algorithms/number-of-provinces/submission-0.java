class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        int cnt = 0;

        for (int i = 0; i < n; i++){
            if (visited[i]) continue;
            cnt++;

            Queue<Integer> q = new ArrayDeque<>();
            q.offer(i);
            visited[i] = true;

            while (!q.isEmpty()){

                int cur = q.poll();

                for (int next = 0; next < n; next++){
                     if (isConnected[cur][next] == 1 && !visited[next]){
                        visited[next] = true;
                        q.offer(next);
                     }
                }
            }
            
         
            



        }

        return cnt;
    }
}