class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;

        int[][] dp = new int[n][n];
        return dfs(arr, 0, n-1, dp);
    }

    private int dfs(int[] arr, int l, int r, int[][] dp){
        if(l == r) return 0;
        if(dp[l][r] > 0) return dp[l][r];

        int ans = Integer.MAX_VALUE;
        for(int k = l; k < r; k++){
            int left = dfs(arr, l, k, dp);
            int right = dfs(arr, k+1, r, dp);

            int maxLeft = 0;
            for(int i = l; i <= k; i++) maxLeft = Math.max(maxLeft, arr[i]);

            int maxRight = 0;
            for(int i = k+1; i <= r; i++) maxRight = Math.max(maxRight, arr[i]);

            ans = Math.min(ans, left + right + (maxLeft * maxRight));
        }
        return dp[l][r] = ans;
    }
}