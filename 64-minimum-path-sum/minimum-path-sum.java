class Solution {
    public int minPathSum(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;

        int[][] dp = new int[r][c];

        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                dp[i][j] = arr[i][j];
                if(i>0 && j>0) dp[i][j] += Math.min(dp[i-1][j], dp[i][j-1]);
                else if(i>0) dp[i][j] += dp[i-1][j];
                else if(j>0) dp[i][j] += dp[i][j-1];
            }
        }
        return dp[r-1][c-1];
    }
}