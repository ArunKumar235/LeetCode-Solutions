class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int total = 0;
        for(int pile: piles) total += pile;

        int[][] dp = new int[n][n];
        for(int i = 0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }

        int alice = func(0, n-1, piles, dp);
        return alice > total - alice;
    }

    private int func(int l, int r, int[] piles, int[][] dp){
        if(l > r) return 0;

        if(dp[l][r] != -1) return dp[l][r];

        boolean evenLen = (piles.length % 2) == 0;
        int first = evenLen ? piles[l] : 0; 
        int last = evenLen ? piles[r] : 0;

        dp[l][r] = Math.max(first + func(l+1, r, piles, dp), last + func(l, r-1, piles, dp));
        return dp[l][r];
    }
}