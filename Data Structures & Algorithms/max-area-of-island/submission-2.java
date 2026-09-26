class Solution {

    public int maxArea = Integer.MIN_VALUE;
    public int[] dx = {1,-1,0,0};
    public int[] dy = {0,0,-1,1};

    public void bfs(int[][] grid, int sx, int sy, 
    boolean[][] visited, int m, int n){
        
        visited[sx][sy] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy, 1});
        
        int cnt = 1;

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n){
                    if (!visited[nx][ny] && grid[nx][ny] == 1){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx,ny,dist+1});
                        cnt++;
                    }
                }
            }
            
        }

        maxArea = Math.max(maxArea, cnt);

        

    }
    public int maxAreaOfIsland(int[][] grid) {


        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == 1 && !visited[r][c]){
                    // bfs 수행 
                    bfs(grid, r, c, visited, m, n);
                }
            }
        }

        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
        
        
    }
}
