class Solution {
    int[] coins;
    int[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        
        this.coins = new int[n+2];
        coins[0] = 1;
        coins[n+1] = 1;
        for(int i = 0; i < n; i++) coins[i+1] = nums[i];

        this.dp = new int[n+2][n+2];
        for(int[] row: dp) Arrays.fill(row, -1);

        return func(0, n+1);    
    }

    private int func(int l, int r){
        if(l + 1 == r) return 0;

        if(dp[l][r] != -1) return dp[l][r];

        int res = 0;
        for(int k = l + 1; k < r; k++){
            res = Math.max(
                res,
                func(l, k) + func(k, r) + (coins[l] * coins[k] * coins[r]) 
            );
        }
        return dp[l][r] = res;
    }
}