class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;

        for(int coin: coins){
            for(int idx = coin; idx<=amount; idx++){
                if(dp[idx-coin] != Integer.MAX_VALUE){
                    dp[idx] = Math.min(dp[idx], 1+dp[idx-coin]);
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
}