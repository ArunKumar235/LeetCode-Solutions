class Solution {
    public int cherryPickup(int[][] arr) {
        int R = arr.length;
        int C = arr[0].length;
        int[][][] dp = new int[R][C][C];
        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return rec(arr, 0, 0, C-1, dp, R, C);
    }

    private int rec(int[][] arr, int r, int c1, int c2, int[][][] dp, int R, int C){
        if(c1<0 || c2<0 || c1>=C || c2>=C){
            return Integer.MIN_VALUE;
        }
        if(r==R) return 0;
        if(dp[r][c1][c2]!=-1) return dp[r][c1][c2];

        int res = 0;

        for(int i = -1; i<=1; i++){
            for(int j = -1; j<=1; j++){
                res = Math.max(res, rec(arr, r+1, c1+i, c2+j, dp, R, C));
            }
        }
        res += (c1==c2) ? arr[r][c1] : arr[r][c1]+arr[r][c2];

        return dp[r][c1][c2]  = res;
    }
}