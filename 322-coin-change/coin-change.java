class Solution {
    public int coinChange(int[] coins, int amount) {
        int N = coins.length;
        int[][] dp = new int[N][amount+1];
        
        for(int t = 0; t<=amount; t++){
            if(t%coins[0]==0) dp[0][t] = t/coins[0];
            else dp[0][t] = (int)(1e9);
        }       

        for(int i = 1; i<N; i++){
            for(int t = 0; t<=amount; t++){
                int notTake = dp[i-1][t];
                int take = (int)(1e9);
                if(t-coins[i]>=0) take = 1+dp[i][t-coins[i]];

                dp[i][t] = Math.min(take, notTake);
            }
        }

        if(dp[N-1][amount] >= (int)(1e9)) return -1;
        return dp[N-1][amount];
    }

    // public int coinChange(int[] coins, int amount) {
    //     int N = coins.length;
    //     int[][] dp = new int[N][amount+1];
    //     for(int[] row: dp){
    //         Arrays.fill(row, -1);
    //     }
    //     int res = rec(coins.length-1, amount, coins, dp);
    //     if(res>=(int)(1e9)) return -1;
    //     return res;
    // }

    // private int rec(int idx, int amount, int[] coins, int[][] dp){
    //     if(idx==0){
    //         if(amount==0)  return 0;
    //         if(amount % coins[0]==0) return amount/coins[0];
    //         return (int)(1e9);
    //     }
    //     if(dp[idx][amount]!=-1) return dp[idx][amount];
    //     int notTake = rec(idx-1, amount, coins, dp);
    //     int take = (int)(1e9);
    //     if(amount-coins[idx] >=0 ) take = 1+ rec(idx, amount-coins[idx], coins, dp);
    //     return dp[idx][amount] = Math.min(take, notTake);
    // }
}