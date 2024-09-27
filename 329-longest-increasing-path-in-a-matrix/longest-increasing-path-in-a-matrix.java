class Solution {
    int[] rowDiff = {-1, 0, 1,  0};
    int[] colDiff = { 0, 1, 0, -1};

    public int longestIncreasingPath(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;
        int[][] dp = new int[R][C];
        int max = 1;
        for(int i = 0; i< R; i++){
            for(int j = 0; j< C; j++){
                dp[i][j] = dfs(mat, dp, i, j, R, C);
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
    public int dfs(int[][] mat, int[][]dp, int row, int col, int R, int C){
        if(dp[row][col]!=0){
            return dp[row][col];
        }
        int max = 1;
        for(int i = 0; i<4; i++){
            int cRow = row+rowDiff[i];
            int cCol = col+colDiff[i];
            if(cRow>=0 && cRow<R && cCol>=0 && cCol<C) {
                if (mat[cRow][cCol] > mat[row][col]) {
                    max = Math.max(max, dfs(mat, dp, cRow, cCol, R, C)+1);
                }
            }
        }
        dp[row][col] = max;
        return dp[row][col];
    }
}