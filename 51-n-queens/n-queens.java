class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        boolean[] rowF = new boolean[n];
        boolean[] colF = new boolean[n];
        boolean[] tlbrF = new boolean[2*n -1];
        boolean[] trblF = new boolean[2*n-1];

        List<List<String>> res = new ArrayList<>();
        
        fill(0, n, board, rowF, colF, tlbrF, trblF, res);

        return res;
    }

    private void fill(int i, int n, boolean[][] board, boolean[] rowF, boolean[] colF, boolean[] tlbrF, boolean[] trblF, List<List<String>> res){
        if(i==n){
            List<String> curr = new ArrayList<>();
            for(boolean[] arr: board){
                StringBuilder sb = new StringBuilder("");
                for(boolean val: arr){
                    sb.append(val ? "Q" : ".");
                }
                curr.add(sb.toString());
            }
            res.add(curr);
            return;
        }
        for(int j = 0; j<n; j++){
            if(!canplace(i,j,n,rowF,colF,tlbrF,trblF)) continue;
            board[i][j]=true;
            rowF[i]=true;
            colF[j]=true;
            tlbrF[i+j]=true;
            trblF[n-1-(i-j)]=true;
            
            fill(i+1, n, board, rowF, colF, tlbrF, trblF, res);

            board[i][j]=false;
            rowF[i]=false;
            colF[j]=false;
            tlbrF[i+j]=false;
            trblF[n-1-(i-j)]=false;
        }
        
    }

    private boolean canplace(int i, int j, int n, boolean[] rowF, boolean[] colF, boolean[] tlbrF, boolean[] trblF){
        if(rowF[i] || colF[j] || tlbrF[i+j] || trblF[n-1-(i-j)]) return false;
        return true;
    }
}