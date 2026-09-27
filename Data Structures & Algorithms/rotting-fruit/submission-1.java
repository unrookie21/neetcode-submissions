class Solution {

    public int[] dx = {1,-1,0,0};
    public int[] dy = {0,0,-1,1};

    public int min = Integer.MIN_VALUE;

    public int orangesRotting(int[][] grid) {

        // 모든 과일이 썩게 되는 최소 minute 
        Queue<int[]> q = new ArrayDeque<>();

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int r = 0 ; r < m; r++){
            for (int c = 0; c < n; c++){
                if (grid[r][c] == 2){
                    q.offer(new int[]{r,c,0});
                    visited[r][c] = true;
                }
            }
        }

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int time = cur[2];
            
            min = Math.max(min, time);

            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n){
                    if (!visited[nx][ny] && grid[nx][ny] == 1){
                        q.offer(new int[]{nx,ny, time + 1});
                        visited[nx][ny] = true;
                    }

                }
            }

            
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){

                if (grid[i][j] != 0 && !visited[i][j]){
                    return -1;
                }
            }
        }

        return min == Integer.MIN_VALUE ? 0 : min ;
        
    }
}
