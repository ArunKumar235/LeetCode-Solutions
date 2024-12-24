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
        return rec(arr, 0, 0, C-1, R, C, dp);
    }

    private int rec(int[][] arr, int r, int c1, int c2, int R, int C, int[][][] dp){
        if(c1<0 || c2<0 || c1>=C || c2>=C ) return Integer.MIN_VALUE;
        if(dp[r][c1][c2] != -1) return dp[r][c1][c2]; 
        if(r==R-1){
            if(c1==c2) return arr[r][c1];
            else return arr[r][c1] + arr[r][c2];
        }

        int max = 0;
        for(int i = -1; i<=1; i++){
            for(int j = -1; j<=1; j++){
                max = Math.max(max, rec(arr, r+1, c1+i, c2+j, R, C, dp));
            }
        }
        if(c1!=c2) max += arr[r][c1]+arr[r][c2];
        else max += arr[r][c1];
        return dp[r][c1][c2] = max;
    }
}