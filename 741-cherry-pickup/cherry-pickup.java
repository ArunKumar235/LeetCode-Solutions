class Solution {
    public int cherryPickup(int[][] grid) {
        int N = grid.length;
        int[][][] dp = new int[N][N][N];
        for(int[][] mat: dp){
            for(int[] row: mat){
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }

        int res = rec(0,0,0, grid, dp, N);

        if(res<0) return 0;

        return res;
    }

    private int rec(int r1, int c1, int c2, int[][] arr, int[][][] dp, int N){
        int r2 = r1+c1-c2;
        if(r1<0 || r2<0 || c1<0 || c2<0 || r1>=N || r2>=N || c1>=N || c2>=N ) return Integer.MIN_VALUE;
        if(arr[r1][c1]==-1 || arr[r2][c2]==-1) return Integer.MIN_VALUE;
        if(r1==N-1 && c1==N-1) return arr[r1][c1];
        
        if(dp[r1][c1][c2] != Integer.MIN_VALUE) return dp[r1][c1][c2];

        int dd = rec(r1+1, c1, c2, arr, dp, N);
        int dr = rec(r1+1, c1, c2+1, arr, dp, N);
        int rd = rec(r1, c1+1, c2, arr, dp, N);
        int rr = rec(r1, c1+1, c2+1, arr, dp, N);

        int res = Math.max(dd, Math.max(dr, Math.max(rd, rr)));

        if(r1==r2 && c1==c2) res += arr[r1][c1];
        else res += arr[r1][c1] + arr[r2][c2];

        return dp[r1][c1][c2] = res; 

    }
}