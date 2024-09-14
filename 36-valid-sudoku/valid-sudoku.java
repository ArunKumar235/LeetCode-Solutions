class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rFlag = new int[9];
        int[] cFlag = new int[9];
        int[] smFlag = new int[9];
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(board[i][j]=='.') continue;
                int val = board[i][j]-'1';
                int smidx = (i/3)*3 + (j/3);
                if((rFlag[i]&(1<<val))!=0) return false;
                if((cFlag[j]&(1<<val))!=0) return false;
                if((smFlag[smidx]&(1<<val))!=0) return false;
                rFlag[i] |= 1<<val;
                cFlag[j] |= 1<<val;
                smFlag[smidx] |= 1<<val;
            }
        }
        return true;
    }
}