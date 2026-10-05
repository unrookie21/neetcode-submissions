class Solution {

    public int[] dx = {1,-1,0,0};
    public int[] dy = {0,0,-1,1};

    public boolean canReach(int t, int[][] grid){
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        if (t < grid[0][0]) return false;
       
        Deque<int[]> q = new ArrayDeque<>();
        // 시작점 처리
        visited[0][0] = true;
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()){
            
            int[] cur = q.poll();
            int x = cur[0] , y = cur[1];
            if (x == n - 1 && y == n - 1) return true;

            for (int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n){
                    if (!visited[nx][ny] && grid[nx][ny] <= t){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }


        }

        return false;

    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int left = 0;
        int right = n * n - 1;

        while (left < right){
            int mid = (left + right) / 2;
            if (canReach(mid, grid)){
                right = mid;
            } 
            else left = mid + 1;
        }

        return left;
    }
}
