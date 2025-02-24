class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        for(int i = 0; i<=amount; i++) if(i%coins[0]==0) dp[i] = 1;

        for(int i = 1; i<coins.length; i++){
            for(int j = 0; j<=amount; j++){
                int nottake = dp[j];
                int take = 0;
                if(j-coins[i]>=0) take = dp[j-coins[i]];
                
                dp[j] = nottake+take;
            }
        }
        return dp[amount];
    }
}