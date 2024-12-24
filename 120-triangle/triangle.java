class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        int r = tri.size();
        int[][] dp = new int[r][r];

        for(int i = 0; i<r; i++){
            for(int j = 0; j<=i; j++){
                dp[i][j] += tri.get(i).get(j);
                if(i>0 && j>0){
                    if(i==j){
                        dp[i][j] += dp[i-1][j-1];
                    }else{
                        dp[i][j] += Math.min(dp[i-1][j], dp[i-1][j-1]);
                    }
                }
                else if(i>0) dp[i][j] += dp[i-1][0];
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i<r; i++){
            res = Math.min(res, dp[r-1][i]);
        }
        return res;
    }
}