class Solution {
    public void solveSudoku(char[][] board) {
        int[] rowF = new int[9];
        int[] colF = new int[9];
        int[] smF = new int[9];

        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(board[i][j]=='.') continue;
                int val = board[i][j] - '0';
                int smidx = (i/3)*3 + (j/3);
                rowF[i] |= 1<<(val);
                colF[j] |= 1<<(val);
                smF[smidx] |= 1<<(val);
            }
        }

        solve(board, rowF, colF, smF);
    }

    private boolean solve(char[][] board, int[] rowF, int[] colF, int[] smF ){
        Cell toFill = getUnfilledCell(board);
        if(toFill==null) return true;
        int row = toFill.row;
        int col = toFill.col;
        int smidx = (row/3)*3 + (col/3);
        for(int val = 1; val<=9; val++){
            if((rowF[row] & (1<<val)) == 0){
                if((colF[col] & (1<<val)) == 0){
                    if((smF[smidx] & (1<<val)) == 0){
                        board[row][col] = (char)('0'+val);
                        rowF[row] |= (1<<val);
                        colF[col] |= (1<<val);
                        smF[smidx] |= (1<<val);
                        if(solve(board, rowF, colF, smF)){
                            return true;
                        }
                        board[row][col] = '.';
                        rowF[row] ^= (1<<val);
                        colF[col] ^= (1<<val);
                        smF[smidx] ^= (1<<val); 
                    }
                }
            }
        }
        return false;
    }

    public Cell getUnfilledCell(char[][] board){
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(board[i][j]=='.') return new Cell(i,j);
            }
        }
        return null;
    }

    static class Cell{
        int row, col;
        public Cell(int i, int j){
            row = i;
            col = j;
        }
    }
}
