class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        
        int v[] = new int[r];
        int h[] = new int[c];

        for(int i = 0; i<r ; i++){
            for(int j = 0; j<c ; j++){
                if(matrix[i][j]==0){
                    v[i] = -1;
                    h[j] = -1;
                }
            }
        }
        for(int i = 0; i<r ; i++){
            for(int j = 0; j<c ; j++){
                if(v[i]==-1 || h[j] == -1){
                    matrix[i][j]=0;
                }
            }
        }
    }
}