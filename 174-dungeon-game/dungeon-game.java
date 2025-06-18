class Solution {
    public int calculateMinimumHP(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int[] li: dp) Arrays.fill(li,-1);
        return func(arr, 0, 0, m, n, dp);
    }

    private int func(int[][] arr, int i, int j, int m, int n, int[][] dp){
        if(i == m || j == n) return (int)1e9;
        if(i == m-1 && j == n-1) return arr[i][j] > 0 ? 1 : 1 - arr[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        
        int down = func(arr,i+1,j,m,n,dp);
        int right = func(arr,i,j+1,m,n,dp);
        int res = Math.min(down,right)-arr[i][j];
        return dp[i][j] = res > 0 ? res : 1;
    }
}