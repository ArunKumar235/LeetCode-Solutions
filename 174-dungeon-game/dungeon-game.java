class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m =  dungeon.length;
        int n = dungeon[0].length;

        int dp[][] = new int[m+1][n+1];
        for(int[] row: dp) Arrays.fill(row, -1);

        return func(dungeon, 0, 0, m, n, dp);
    }

    private int func(int[][] arr, int i, int j, int m, int n, int[][] dp){
        if(i==m || j==n) return (int)1e9;
        if(i==m-1 && j==n-1) return arr[i][j]<0 ? 1-arr[i][j] : 1;

        if(dp[i][j]!=-1) return dp[i][j];

        int rt = func(arr, i, j+1, m, n, dp);
        int dn = func(arr, i+1, j, m, n, dp);

        int need = Math.min(rt, dn) - arr[i][j];

        return dp[i][j] = need > 0 ? need : 1; 
    }
}