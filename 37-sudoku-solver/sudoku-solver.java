class Solution {
    public static void solveSudoku(char[][] board) {
        int[] rFlag = new int[9];
        int[] cFlag = new int[9];
        int[] smFlag = new int[9];
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(board[i][j]=='.') continue;
                int val = board[i][j] - '0';
                int smidx = (i/3)*3+(j/3);
                rFlag[i] |= 1<<(val);
                cFlag[j] |= 1<<(val);
                smFlag[smidx] |= 1<<(val);
            }
        }
//        for(int i = 0;  i<9; i++){
//            System.out.println(Integer.toBinaryString(rFlag[i])+" "+Integer.toBinaryString(cFlag[i])+" "+Integer.toBinaryString(smFlag[i]));
//        }
        solve(board, rFlag, cFlag, smFlag);
    }

    public static boolean solve(char[][] board, int[] rFlag, int[] cFlag, int[] smFlag){
        Cell toFill = getUnfilledCell(board);
        if(toFill==null){
            return true;
        }
        int smidx = (toFill.row/3)*3 + toFill.col/3;
        for(int dig = 1; dig<=9; dig++){
            if((rFlag[toFill.row]&(1<<dig))==0){
                if((cFlag[toFill.col]&(1<<dig))==0){
                    if((smFlag[smidx]&(1<<dig))==0){
                        board[toFill.row][toFill.col] = (char)('0'+dig);
                        rFlag[toFill.row] |= (1<<dig);
                        cFlag[toFill.col] |= (1<<dig);
                        smFlag[smidx] |= (1<<dig);
                        if(solve(board, rFlag, cFlag, smFlag)){
                            return true;
                        }
                        board[toFill.row][toFill.col] = '.';
                        rFlag[toFill.row] ^= (1<<dig);
                        cFlag[toFill.col] ^= (1<<dig);
                        smFlag[smidx] ^= (1<<dig);
                    }
                }
            }
        }
        return false; // Sudoku is unsolvable
    }
    public static Cell getUnfilledCell(char[][] board){
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(board[i][j]=='.') return new Cell(i,j);
            }
        }
        return null;
    }
}

class Cell {
    int row, col;
    public Cell(int row, int col){
        this.row = row;
        this.col = col;
    }
}