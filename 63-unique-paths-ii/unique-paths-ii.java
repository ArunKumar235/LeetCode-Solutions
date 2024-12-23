class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        int[][] dp = new int[r][c];
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(arr[i][j] == 1) dp[i][j] = 0;
                else if(i==0 && j==0) dp[i][j] = 1;
                else{
                    if(i>0) dp[i][j] += dp[i-1][j];
                    if(j>0) dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[r-1][c-1];
    }
}