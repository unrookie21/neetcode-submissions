class Solution {

    public int[] dx = {1,-1,0,0};
    public int[] dy = {0,0,-1,1};

    public void bfs(char[][] grid, int sx, int sy, boolean[][] visited){
        Queue<int[]> q = new ArrayDeque<>();
        visited[sx][sy] = true;

        int m = grid.length;
        int n = grid[0].length;

        q.offer(new int[]{sx, sy});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0 ; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n){
                    if (!visited[nx][ny] && grid[nx][ny] == '1'){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }



    }

    // 섬 개수 구하기 
    public int numIslands(char[][] grid) {

        int cnt = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int r = 0 ; r < grid.length; r++){
            for (int c = 0 ; c < grid[0].length; c++){
                if (grid[r][c] == '1' && !visited[r][c]){
                    // 탐색 시작 
                    bfs(grid, r, c, visited);
                    // 탐색완료 후 count 증가
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
