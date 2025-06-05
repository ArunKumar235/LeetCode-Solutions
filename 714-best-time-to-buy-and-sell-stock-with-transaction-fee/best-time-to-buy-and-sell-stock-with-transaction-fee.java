class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int[][] dp = new int[n+1][2];
        for(int i = n-1; i>=0; i--){
            
            int buy = - prices[i] + dp[i+1][1];
            int skip1 = dp[i+1][0];

            dp[i][0] = Math.max(buy, skip1);

            int sell = -fee + prices[i] + dp[i+1][0];
            int skip2 = dp[i+1][1];

            dp[i][1] = Math.max(sell, skip2);
        }

        return dp[0][0];
    }
}