class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        
        for(int i = 0; i<=amount; i++) if(i%coins[0]==0) dp[0][i] = 1;

        for(int i = 1; i<coins.length; i++){
            for(int j = 0; j<=amount; j++){
                int nottake = dp[i-1][j];
                int take = 0;
                if(j-coins[i]>=0) take = dp[i][j-coins[i]];
                
                dp[i][j] = nottake+take;
            }
        }
        return dp[coins.length-1][amount];
        
    }

    // private int rec(int idx, int amount, int[] coins, int[][] dp){
    //     if(idx==0){
    //         if(amount%coins[0]==0) return 1;
    //         return 0;
    //     }
    //     if(dp[idx][amount]!=-1) return dp[idx][amount];

    //     int nottake = rec(idx-1, amount, coins, dp);
    //     int take = 0;
    //     if(amount-coins[idx]>=0) take = rec(idx, amount-coins[idx], coins, dp);

    //     return dp[idx][amount] = nottake+take;
    // }
}