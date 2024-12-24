class Solution {
    public int minPathSum(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] dp = new int[r][c];
        return rec(grid, r-1, c-1, dp);
    }

    private int rec(int[][] arr, int r, int c, int[][] dp){
        if(r==0 && c==0){
            return arr[r][c];
        }
        if(r<0 || c<0) return Integer.MAX_VALUE;
        if(dp[r][c] != 0) return dp[r][c];

        return dp[r][c] = Math.min(rec(arr , r-1, c, dp), rec(arr, r, c-1, dp)) + arr[r][c];
    }
}