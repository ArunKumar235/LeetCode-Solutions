class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        return rec(coins.length-1, amount, coins, dp);
    }

    private int rec(int idx, int amount, int[] coins, int[][] dp){
        if(idx==0){
            if(amount%coins[0]==0) return 1;
            return 0;
        }
        if(dp[idx][amount]!=-1) return dp[idx][amount];

        int nottake = rec(idx-1, amount, coins, dp);
        int take = 0;
        if(amount-coins[idx]>=0) take = rec(idx, amount-coins[idx], coins, dp);

        return dp[idx][amount] = nottake+take;
    }
}