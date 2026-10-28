class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        
        int[] coins = new int[n+2];
        coins[0] = 1;
        coins[n+1] = 1;
        for(int i = 0; i < n; i++) coins[i+1] = nums[i];

        int[][] dp = new int[n+2][n+2];
        
        for(int l = n+1; l >= 0; l--){
            for(int r = l + 1; r <= n + 1; r++){
                if(l + 1 == r){
                    dp[l][r] = 0;
                    continue;
                }

                dp[l][r] = 0;
                // k is choosen as the last balloon to be burst in the boundary of (l, r)
                for(int k = l + 1; k < r; k++){
                    dp[l][r] = Math.max(
                        dp[l][r], 
                        dp[l][k] + dp[k][r] + (coins[l] * coins[k] * coins[r])
                    );
                }
            }
        }
        return dp[0][n+1];   
    }
}