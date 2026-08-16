class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int total = 0;
        for(int pile: piles) total += pile;
        
        int[][] dp = new int[n][n];
        
        for(int l = n-1; l>=0; l--){
            for(int r = l; r<n; r++){
                boolean evenLen = (r-l) %2 == 0;
                int left = evenLen ? piles[l] : 0;
                int right = evenLen ? piles[r] : 0;
                if(l==r){
                    dp[l][r] = piles[l];
                }else{
                    dp[l][r] = Math.max(left + dp[l+1][r], right + dp[l][r-1]);
                }
            }
        }
        return dp[0][n-1] > total - dp[0][n-1];
    }
}