class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] li: dp){
            Arrays.fill(li, -1);
        }
        return rec(satisfaction, 0, 1, dp);
    }

    private int rec(int[] arr, int idx, int mul, int[][] dp){
        if(idx==arr.length) return 0;
        if(dp[idx][mul] != -1) return dp[idx][mul];

        int pick = arr[idx]*mul + rec(arr, idx+1, mul+1, dp);
        int not_pick = rec(arr, idx+1, mul, dp);

        return dp[idx][mul] = Math.max(pick, not_pick);
    }
}