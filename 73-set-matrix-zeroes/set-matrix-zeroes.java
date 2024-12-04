class Solution {
    public void setZeroes(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int row[] = new int[r];
        int col[] = new int[c];
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(mat[i][j]==0){
                    row[i] = -1;
                    col[j] = -1;
                }
            }
        }
        for(int i = 0; i<r; i++){
            if(row[i]==-1){
                for(int j = 0; j<c; j++){
                    mat[i][j] = 0;
                }
            }
        }
        for(int j = 0; j<c; j++){
            if(col[j]==-1){
                for(int i = 0; i<r; i++){
                    mat[i][j] = 0;
                }
            }
        }
    }
}