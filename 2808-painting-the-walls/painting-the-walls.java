class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = time.length;
        int[][] dp = new int[n][n+1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return func(cost, time, n-1, n, dp);
    }

    private int func(int[] cost, int[] time, int idx, int wallsRem, int[][] dp){
        if(wallsRem <= 0) return 0; // one of possible ways
        if(idx < 0) return (int) 1e9;  // not useful
        if(dp[idx][wallsRem] != -1) return dp[idx][wallsRem];

        int notTake = 0 + func(cost, time, idx-1, wallsRem, dp);
        int take = cost[idx] + func(cost, time, idx-1, wallsRem -1 - time[idx], dp);

        return dp[idx][wallsRem] = Math.min(notTake, take);
    }
}