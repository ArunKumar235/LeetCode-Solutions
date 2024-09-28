class Solution {
    public boolean canPlace(boolean[]rowF,boolean[]colF,boolean[]trblF,boolean[]tlbrF,int row,int col,int n){
        if(rowF[row] || colF[col] || trblF[row+col] || tlbrF[n-1-(row-col)]){
            return false;
        }
        return true;
    }
    public void fill(int row,boolean[][]board,boolean[]rowF,boolean[]colF,boolean[]trblF,boolean[]tlbrF,List<List<String>>ans,int n){
        if(row==n){
            List<String>placement=new ArrayList<>();
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(board[i][j]){
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                    }
                }
                placement.add(sb.toString());
                sb.setLength(0);
            }
            ans.add(placement);
            return;
        }
        for(int col=0;col<n;col++){
            if(canPlace(rowF,colF,trblF,tlbrF,row,col,n)){
                rowF[row]=true;
                colF[col]=true;
                trblF[row+col]=true;
                tlbrF[n-1-(row-col)]=true;
                board[row][col]=true;
                fill(row+1,board,rowF,colF,trblF,tlbrF,ans,n);
                rowF[row]=false;
                colF[col]=false;
                trblF[row+col]=false;
                tlbrF[n-1-(row-col)]=false;
                board[row][col]=false;
            }
        }

    }
    public List<List<String>> solveNQueens(int n) {
        boolean[][]board=new boolean[n][n];
        boolean[]rowF=new boolean[n];
        boolean[]colF=new boolean[n];
        boolean[]trblF=new boolean[2*n - 1];
        boolean[]tlbrF=new boolean[2*n - 1];
        List<List<String>>ans=new ArrayList<>();
        fill(0,board,rowF,colF,trblF,tlbrF,ans,n);
        return ans;
    }
}