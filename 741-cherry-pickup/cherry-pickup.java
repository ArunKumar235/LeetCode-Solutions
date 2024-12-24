class Solution {
    public int cherryPickup(int[][] grid) {
        int N = grid.length;
        int[][][] dp = new int[N][N][N];
        for(int[][] m : dp){
            for(int[] row : m){
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        return Math.max(0, rec(grid, 0, 0, 0, N, dp));
    }

    private int rec(int[][] arr, int r1, int c1, int c2, int N, int[][][] dp){
        int r2 = r1+c1 - c2;

        if(c1>=N || c2>=N || r1>=N || r2>=N || arr[r1][c1] == -1 || arr[r2][c2] == -1) return Integer.MIN_VALUE;
        if((r1==N-1 && c1==N-1) || (r2==N-1 && c2==N-1)) return arr[r1][c1];
        if(dp[r1][c1][c2] != Integer.MIN_VALUE) return dp[r1][c1][c2];

        int dd = rec(arr, r1+1, c1, c2, N, dp);
        int dr = rec(arr, r1+1, c1, c2+1, N, dp);
        int rd = rec(arr, r1, c1+1, c2, N, dp);
        int rr = rec(arr, r1, c1+1, c2+1, N, dp);

        int res = Math.max(dd, Math.max(dr, Math.max(rd, rr)));

        if(r1==r2 && c1==c2) res += arr[r1][c1];
        else res += arr[r1][c1] + arr[r2][c2];

        return dp[r1][c1][c2] = res;
    }
}