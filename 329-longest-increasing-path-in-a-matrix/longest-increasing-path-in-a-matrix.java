class Solution {
    public int longestIncreasingPath(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;
        int[][] dp = new int[R][C];
        int max = -1;
        for(int i = 0;i <R; i++){
            for(int j = 0; j<C; j++){
                dp[i][j] = dfs(mat,dp,i,j,R,C,-1);
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
    public int dfs(int[][] mat, int[][] dp, int row, int col, int R, int C, int prev){
        if(row>=R || row<0 || col>=C || col<0){
            return 0;
        }
        if(mat[row][col]<=prev){
            return 0;
        }
        if(dp[row][col]!=0){
            return dp[row][col];
        }
        int top = dfs(mat, dp, row-1, col, R, C, mat[row][col]);
        int bottom = dfs(mat, dp, row+1, col, R, C, mat[row][col]);
        int left = dfs(mat, dp, row, col-1, R, C, mat[row][col]);
        int right = dfs(mat, dp, row, col+1, R, C, mat[row][col]);
        dp[row][col] = Math.max(Math.max(top,bottom), Math.max(left, right)) + 1;
        return dp[row][col];
    }
    
}