class Solution {

    public int[] dx = {1,-1,0,0};
    public int[] dy = {0,0,-1,1};

    // index : 처리해야할 word 의 index
    public boolean dfs(int index, boolean[][] visited, 
    char[][] board, String word,int x, int y){

        int m = board.length;
        int n = board[0].length;

        if (word.charAt(index) != board[x][y]) return false;
        if (index == word.length() - 1) return true;

        visited[x][y] = true;

        for (int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n){
                if (!visited[nx][ny]){
                    if (dfs(index +1, visited, board, word, nx, ny)){
                        return true;
                    }
                }
            }
        }
        visited[x][y] = false;
        return false;

    }
    
    public boolean exist(char[][] board, String word) {
        
        // board 안에 word 와 매치되는 단어가 있는지 확인
        // 있으면 true 반환 , 없으면 false
        
      
        int m = board.length;
        int n = board[0].length;

        char firstChar = word.charAt(0);
        boolean[][] visited = new boolean[m][n];

        for (int row = 0; row < m; row++){
            for (int col = 0; col < n; col++){
                if (board[row][col] == firstChar){
                    if(dfs(0, visited, board, word, row, col)){
                        return true;
                    }
                }
            }
        }
        
        return false;
        


    }
}
