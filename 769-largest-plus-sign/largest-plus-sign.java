class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] mat = new int[n][n];
        for(int[] m: mat){
            Arrays.fill(m,1);
        }
        for(int[] m: mines){
            mat[m[0]][m[1]] = 0;
        }
        int[][] left = new int[n][n];
        int[][] right = new int[n][n];
        int[][] top = new int[n][n];
        int[][] bottom = new int[n][n];

        for(int i = 0; i<n; i++){
            left[i][0] = mat[i][0];
            for(int j = 1; j<n; j++){
                left[i][j] = mat[i][j]==0 ? 0 : left[i][j-1] +1;
            }
            right[i][n-1] = mat[i][n-1];
            for(int j = n-2; j>=0; j--){
                right[i][j] = mat[i][j]==0 ? 0 : right[i][j+1]+1;
            }
        }
        for(int j = 0; j<n; j++){
            top[0][j] = mat[0][j];
            for(int i = 1; i<n; i++){
                top[i][j] = mat[i][j]==0 ? 0 : top[i-1][j] + 1;
            }
            bottom[n-1][j] = mat[n-1][j];
            for(int i = n-2; i>=0; i--){
                bottom[i][j] = mat[i][j]==0 ? 0 : bottom[i+1][j] + 1;
            }
        }
        int max = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                max = Math.max(
                    max, 
                    Math.min(
                        Math.min(left[i][j], right[i][j]), 
                        Math.min(top[i][j], bottom[i][j])));
            }
        }
        return max;
    }
}