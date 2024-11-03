class Solution {
    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        for(int i = 0; i<r; i++){
            dfs(board,i,0);
        }
        for(int i = 0; i<r; i++){
            dfs(board,i,c-1);
        }
        for(int i = 0; i<c; i++){
            dfs(board,0,i);
        }
        for(int i = 0; i<c; i++){
            dfs(board,r-1,i);
        }
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(board[i][j]=='I') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }

    public void dfs(char[][] board, int row, int col){
        if(row==board.length || col==board[0].length || row==-1 || col==-1) return;
        if(board[row][col]=='X' || board[row][col]=='I') return;
        board[row][col] = 'I';
        dfs(board, row, col-1);
        dfs(board, row, col+1);
        dfs(board, row-1, col);
        dfs(board, row+1, col);
    }
}