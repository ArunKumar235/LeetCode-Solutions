class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        boolean blocked = false;
        for(int i = 0; i<r; i++){
            if(obstacleGrid[i][0]==1){
                blocked = true;
            }
            if(blocked) obstacleGrid[i][0]=1;
        }
        blocked = false;
        for(int i = 0; i<c; i++){
            if(obstacleGrid[0][i]==1){
                blocked = true;
            }
            if(blocked) obstacleGrid[0][i]=1;
        }
        int[][] dp = new int[r][c];
        for(int i = 0; i<r; i++){
            Arrays.fill(dp[i], -1);
        }
        return rec(obstacleGrid, r-1, c-1, dp);
    }

    private int rec(int[][] mat, int r, int c, int[][] dp){
        if(dp[r][c] != -1) return dp[r][c];
        if(mat[r][c]==1) return 0;
        if(r==0 || c==0) return 1;

        return dp[r][c] = rec(mat, r-1, c, dp) + rec(mat, r, c-1, dp);
    }
}