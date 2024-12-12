class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int[][] dp = new int[n+1][n+1];
        int max = 0;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=i; j++){
                dp[i][j] = dp[i-1][j-1] + satisfaction[i-1]*(j);
                max = Math.max(max, dp[i][j]);
            }
        }
        // for(int[] li: dp){
        //     System.out.println(Arrays.toString(li));
        // }
        return max;
    }
}