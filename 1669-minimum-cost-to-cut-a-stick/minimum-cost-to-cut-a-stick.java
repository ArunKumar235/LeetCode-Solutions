class Solution {
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length;

        int[] points = new int[m+2];
        for(int i = 0; i < m; i++){
            points[i+1] = cuts[i];
        }
        points[0] = 0;
        points[m+1] = n;

        this.dp = new int[m+2][m+2];
        for(int[] row: dp) Arrays.fill(row, -1);

        return func(0, m+1, points);
    }

    private int func(int l, int r, int[] points){
        if(l + 1 == r) return 0;
        
        if(dp[l][r] != -1) return dp[l][r];

        int res = Integer.MAX_VALUE;
        for(int k = l + 1; k < r; k++){
            res = Math.min(
                res, 
                func(l, k, points) + func(k, r, points) + (points[r] - points[l])
            );
        }
        return dp[l][r] = res;    
    }
}