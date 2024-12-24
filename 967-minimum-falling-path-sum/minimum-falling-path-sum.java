class Solution {
    public int minFallingPathSum(int[][] arr) {
        int r = arr.length;
        int[][] dp = new int[r][r];
        
        for(int i = 0; i<r; i++){
            for(int j = 0; j<r; j++){
                dp[i][j] = arr[i][j]; 
                if(i==0) continue;
                if(j>0 && j+1!=r) dp[i][j] += Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1]));
                else if(j>0) dp[i][j] += Math.min(dp[i-1][j-1], dp[i-1][j]);
                else if(j+1!=r) dp[i][j] += Math.min(dp[i-1][j], dp[i-1][j+1]);
            }
        }
        int res = Integer.MAX_VALUE;
        for(int v: dp[r-1]){
            res = Math.min(res, v);
        }
        return res;
    }
}