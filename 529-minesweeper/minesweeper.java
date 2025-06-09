class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board == null || board.length == 0) return board;
        int R = board.length;
        int C = board[0].length;
        
        int x = click[0], y = click[1];
        
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
            return board;
        }
        reveal(board, x, y, R, C);
        return board;
    }

    private void reveal(char[][] board, int i, int j, int R, int C){
        if(i < 0 || i >= R || j < 0 || j >= C || board[i][j] != 'E'){
            return;
        }
        int mineCount = 0;
        for(int x = -1; x<=1; x++){
            for(int y = -1; y<=1; y++){
                if(i+x>=0 && i+x<R && j+y>=0 && j+y<C && board[i+x][j+y]=='M'){
                    mineCount++;
                }
            }
        }
        if(mineCount > 0){
            board[i][j] = (char) (mineCount + '0');
            return;
        }

        board[i][j] = 'B';

        for(int x = -1; x<=1; x++){
            for(int y = -1; y<=1; y++){
                reveal(board, i+x, j+y, R, C);
            }
        }
    }
}