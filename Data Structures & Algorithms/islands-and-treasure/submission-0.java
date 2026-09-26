class Solution {

    public int[] dx = {1,-1,0,0};
    public int[] dy = {0,0,-1,1};

   
    public void islandsAndTreasure(int[][] grid) {
        // -1 : 벽
        // 0 : 보물상자
        // inf : 땅 

        // 각 셀을, 가장 가까운 보물상자로부터의 거리로 채운다.

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new ArrayDeque<>();

        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == 0){
                    q.offer(new int[]{r,c, 0});
                    visited[r][c] = true;
                }

            }
        }

        while (!q.isEmpty()){

            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            for (int i = 0 ; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n){
                    if (!visited[nx][ny] && grid[nx][ny] != -1){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx,ny,dist+1});
                        grid[nx][ny] = dist + 1;
                    }
                }
            }
            
            


        }

        


        
        
    }
}
