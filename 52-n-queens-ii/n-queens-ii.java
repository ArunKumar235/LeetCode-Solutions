class Solution {
    boolean[] rowF;
    boolean[] colF;
    boolean[] tlbrF;
    boolean[] trblF;
    boolean[][] board;
    int count = 0;
    
    public int totalNQueens(int n) {
        rowF = new boolean[n];
        colF = new boolean[n];
        tlbrF = new boolean[2*n -1];
        trblF = new boolean[2*n -1];
        board = new boolean[n][n];
        fill(0,n);
        return count;
    }

    public void fill(int row, int n){
        if(row==n){
            count++;
            return;
        }
        for(int col = 0; col<n; col++){
            if(!canPlace(row,col, n)) continue;
            rowF[row] = true;
            colF[col] = true;
            trblF[row+col] = true;
            tlbrF[n-1-(row-col)] = true;
            board[row][col] = true;
            fill(row+1, n);
            rowF[row] = false;
            colF[col] = false;
            trblF[row+col] = false;
            tlbrF[n-1-(row-col)] = false;
            board[row][col] = false;
        }
    }

    public boolean canPlace(int row, int col, int n){
        return !(rowF[row]||colF[col]||trblF[row+col]||tlbrF[n-1-(row-col)]||board[row][col]);
    }
}