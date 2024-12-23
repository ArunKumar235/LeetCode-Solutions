class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        int[][] dp = new int[r][c];
        for(int i = 0; i<r; i++){
            Arrays.fill(dp[i], -1);
        }
        return rec(r-1, c-1, arr, dp);
    }

    private int rec(int r, int c, int[][] arr, int[][] dp){
        if(r>=0 && c>=0 && arr[r][c] == 1) return 0;
        if(r==0 && c==0) return 1;
        if(r<0 || c<0) return 0;
        if(dp[r][c] != -1) return dp[r][c];

        return dp[r][c] = rec(r-1, c, arr, dp) + rec(r, c-1, arr, dp);
    }
}