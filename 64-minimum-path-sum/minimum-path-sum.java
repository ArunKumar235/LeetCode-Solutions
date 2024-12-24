class Solution {
    public int minPathSum(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;

        int[][] dp = new int[r][c];
        dp[0][0] = arr[0][0];
        for(int i = 1; i<r; i++){
            dp[i][0] = dp[i-1][0] + arr[i][0];
        }
        for(int j = 1; j<c; j++){
            dp[0][j] = dp[0][j-1] + arr[0][j];
        }
        for(int i = 1; i<r; i++){
            for(int j = 1; j<c; j++){
                dp[i][j] = arr[i][j];
                dp[i][j] += Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[r-1][c-1];
    }
}