class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n+1][2];

        for(int i = n-1; i>=0; i--){
            for(int j = 0; j<=1; j++){
                if(j==0){
                    int buy = -prices[i] + dp[i+1][1];
                    int skip = dp[i+1][0];

                    dp[i][j] = Math.max(buy, skip);
                }else{
                    int sell = prices[i] + dp[i+1][0];
                    int skip = dp[i+1][1];

                    dp[i][j] = Math.max(sell, skip);
                }
            }
        }

        return dp[0][0];
    }
}