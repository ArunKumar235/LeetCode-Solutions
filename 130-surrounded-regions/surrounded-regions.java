class Solution {
    int[] rowDiff = new int[]{-1, 0, 1, 0};
    int[] colDiff = new int[]{0, 1, 0, -1};

    public void solve(char[][] board) {
        int R = board.length;
        int C = board[0].length;

        for(int i = 0; i<R; i++){
            if(board[i][0] == 'O') dfs(i, 0, board);
            if(board[i][C-1] == 'O') dfs(i, C-1, board);
        }
        for(int j = 0; j<C; j++){
            if(board[0][j] == 'O') dfs(0, j, board);
            if(board[R-1][j] == 'O') dfs(R-1, j, board);
        }

        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'A') board[i][j] = 'O';
            }
        }
        return;
    }

    private void dfs(int r, int c, char[][] board){
        board[r][c] = 'A';

        for(int i = 0; i<4; i++){
            int newR = r + rowDiff[i];
            int newC = c + colDiff[i];

            if( 0 <= newR && newR < board.length &&
                0 <= newC && newC < board[0].length &&
                board[newR][newC] == 'O'
            ){
                dfs(newR, newC, board);
            }
        }
    }
}