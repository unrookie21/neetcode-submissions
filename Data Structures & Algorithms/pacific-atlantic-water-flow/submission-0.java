class Solution {

    public int[] dx = {1,-1,0,0};
    public int[] dy = {0,0,-1,1};

    public void bfs(Queue<int[]> q, 
    boolean[][] visited, int[][] grid){

        int m = grid.length;
        int n = grid[0].length;

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (nx >= 0 && nx < m && ny >= 0 && ny < n){
                    if (!visited[nx][ny] && grid[nx][ny] >= grid[x][y]){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }


    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        // 태평양, 대성댱 양쪽으로 모두 물이 흘러갈 수 있는
        // 셀을 찾기

        List<List<Integer>> ans = new ArrayList<>();

        Queue<int[]> pacific = new ArrayDeque<>();
        Queue<int[]> atlantic = new ArrayDeque<>();

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pVisited = new boolean[m][n];
        boolean[][] aVisited = new boolean[m][n];

        // pacific 먼저

        // 0행에서 0열 ~ n-1 열 삽입
        for (int i = 0; i <= n-1; i++){
            pacific.offer(new int[]{0, i});
            pVisited[0][i] = true;
        }

        // 0열 삽입
        for (int i = 1; i <= m-1; i++){
            pacific.offer(new int[]{i, 0});
            pVisited[i][0] = true;
        }

        // atlantic 
        
        // m-1 행에서 0열 ~ n-1 열 삽입
        for (int i = 0; i <= n-1; i++){
            atlantic.offer(new int[]{m-1, i});
            aVisited[m-1][i] = true;
        }

        // n-1 열에서 0행 ~ m-2 행 삽입
        for (int i = 0; i <= m -2; i++){
            atlantic.offer(new int[]{i, n-1});
            aVisited[i][n-1] = true;
        }

        bfs(pacific, pVisited, heights);
        bfs(atlantic, aVisited, heights);

        for (int r = 0; r < m; r++){
            for (int c = 0; c < n; c++){
                if (pVisited[r][c] && aVisited[r][c]){
                    ans.add(List.of(r, c));
                }
            }
        }

        return ans;
        
    
        

        
        
    }
}
