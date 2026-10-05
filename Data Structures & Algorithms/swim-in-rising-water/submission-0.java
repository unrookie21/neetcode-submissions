class Solution {

    public int[] dx = {1,-1,0,0};
    public int[] dy = {0,0,-1,1};

    public int swimInWater(int[][] grid) {

        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        // (현재까지 경로중에서 최댓값이 가장 작은 애를 poll)
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        // 시작점 처리
        visited[0][0] = true;
        pq.offer(new int[]{grid[0][0], 0, 0});

        while (!pq.isEmpty()){
            
            int[] cur = pq.poll();
            int cost = cur[0], x = cur[1] , y = cur[2];
            if (x == n - 1 && y == n - 1) return cost;

            for (int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n){
                    if (!visited[nx][ny]){
                        visited[nx][ny] = true;
                        pq.offer(new int[]{Math.max(cost, grid[nx][ny]), nx, ny});
                    }
                }
            }


        }

        return -1;
    }
}
