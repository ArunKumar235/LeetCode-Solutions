class Solution {
    public int cherryPickup(int[][] grid) {
        int R = grid.length;
        int[][][] dp = new int[R][R][R];
        for(int i = 0; i<R; i++){
            for(int j = 0; j<R; j++){
                Arrays.fill(dp[i][j], Integer.MIN_VALUE);
            }
        }
        return Math.max(0, rec(grid, 0, 0, 0, R, dp));
    }

    private int rec(int[][] arr, int r1, int c1, int c2, int R, int[][][] dp){
        int r2 = r1+c1-c2;
        if(c1>=R || c2>=R || r1>=R || r2>=R) return Integer.MIN_VALUE;
        if(arr[r1][c1]==-1 || arr[r2][c2]==-1) return Integer.MIN_VALUE;
        if(r1==R-1 && c1==R-1) return arr[r1][c1];
        if(dp[r1][c1][c2] != Integer.MIN_VALUE) return dp[r1][c1][c2];

        int dd = rec(arr, r1+1, c1, c2, R, dp);
        int dr = rec(arr, r1+1, c1, c2+1, R, dp);
        int rd = rec(arr, r1, c1+1, c2, R, dp);
        int rr = rec(arr, r1, c1+1, c2+1, R, dp);
        int res = Math.max(dd, Math.max(dr, Math.max(rd, rr)));
        
        if(r1==r2 && c1==c2) res += arr[r1][c1];
        else res += arr[r1][c1] + arr[r2][c2];

        return dp[r1][c1][c2] = res;
        
    }
}