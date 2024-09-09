class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int x = 1;
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;
        while(left<=right && top<=bottom){
            for(int i = left; i<=right; i++){
                mat[top][i] = x++;
            }
            top++;
            for(int i = top; i<=bottom; i++){
                mat[i][right] = x++;
            }
            right--;
            if(top<=bottom){
                for(int i = right; i>=left; i--){
                    mat[bottom][i] = x++;
                }
                bottom--;
            }if(left<=right){
                for(int i = bottom; i>=top; i--){
                    mat[i][left] = x++;
                }
                left++;
            }
        }
        return mat;
    }
}