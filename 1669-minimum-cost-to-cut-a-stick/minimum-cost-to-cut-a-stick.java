class Solution {
    int[] cuts;
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);

        int m = cuts.length;
        this.cuts = cuts;
        this.dp = new int[m][m];

        for(int[] row: dp) Arrays.fill(row, -1);

        return func(0, n, 0, m-1);
    }

    private int func(int l, int r, int cl, int cr){
        if(cl > cr) return 0;
        
        if(dp[cl][cr] != -1) return dp[cl][cr];

        dp[cl][cr] = Integer.MAX_VALUE;

        for(int k = cl; k <= cr; k++){
            dp[cl][cr] = Math.min(
                dp[cl][cr], 
                func(l, cuts[k], cl, k-1) + func(cuts[k], r, k+1, cr) + (r-l)
            );
        }
        return dp[cl][cr];
    }
}