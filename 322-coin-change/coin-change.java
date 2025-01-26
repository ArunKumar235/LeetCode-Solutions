class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);

        int res = rec(coins, amount, dp);

        if(res == Integer.MAX_VALUE) res = -1;

        return res;
    }

    private int rec(int[] coins, int amount, int[] dp){
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;
        if(dp[amount] != -1) return dp[amount];

        int res = Integer.MAX_VALUE;    
        for(int coin: coins){
            int curr = rec(coins, amount-coin, dp);
            if(curr != Integer.MAX_VALUE) res = Math.min(res, curr+1);
        }
        return dp[amount] = res;
    }
}