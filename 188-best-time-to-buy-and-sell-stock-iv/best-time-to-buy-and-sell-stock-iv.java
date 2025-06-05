class Solution {
    public int maxProfit(int K, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][K+1];

        for(int i = n-1; i>=0; i--){
            for(int k = 0; k<=K; k++){
                if(k==0){
                    dp[i][0][0] = dp[i+1][0][0];
                    dp[i][1][0] = dp[i+1][1][0];
                }else{
                    int buy = -prices[i] + dp[i+1][1][k];
                    int skip1 = dp[i+1][0][k];
                    
                    dp[i][0][k] = Math.max(buy, skip1);

                    int sell = prices[i] + dp[i+1][0][k-1];
                    int skip2 = dp[i+1][1][k];

                    dp[i][1][k] = Math.max(sell, skip2);
                }
            }
        }
        
        return dp[0][0][K];
    }
}