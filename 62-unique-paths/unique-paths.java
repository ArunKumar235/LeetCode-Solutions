class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return rec(m-1, n-1, dp);
    }

    private int rec(int m, int n, int[][] dp){
        if(dp[m][n] != 0) return dp[m][n];
        if(m==0 || n==0){
            return 1;
        }
        return dp[m][n] = rec(m-1,n, dp) + rec(m,n-1, dp);
    }
}