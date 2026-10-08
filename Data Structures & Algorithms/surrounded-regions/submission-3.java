class Solution {

    public int[] dx = {1,-1,0,0};
    public int[] dy = {0,0,-1,1};

    public void bfs(char[][] board, int sx, int sy){

        int m = board.length;
        int n = board[0].length;

        board[sx][sy] = 'T';
        Queue<int[]> q= new ArrayDeque<>();
        
        q.offer(new int[]{sx,sy});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n){
                    if (board[nx][ny] == 'O'){
                        board[nx][ny] = 'T';
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        


    }

    public void solve(char[][] board) {

        // return 할 필요 없음
        // 가장 자리에서 O를 먼저 찾는다.

        // 캡쳐 안되는 칸을 임시값 T로 바꾸고, 동시에 방문처리 기능도 수행하게끔 한다.

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++){
            if (board[i][0] == 'O') bfs(board, i, 0);
            if (board[i][n-1] == 'O') bfs(board, i, n-1);
        }

        for (int i = 0; i < n; i++){
            if (board[0][i] == 'O') bfs(board, 0, i);
            if (board[m-1][i] == 'O') bfs(board, m-1, i);
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
        
    }
}
