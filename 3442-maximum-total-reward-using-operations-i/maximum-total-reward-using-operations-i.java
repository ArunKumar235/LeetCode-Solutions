class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);

        int n = rewardValues.length;
        // max value of result could be 1999(total) + 2000(arr[i])
        int[][] dp = new int[n][4000];
        for(int[] arr: dp) Arrays.fill(arr, -1);

        return func(0, 0, rewardValues, dp);
    }

    private int func(int idx, int total, int[] arr, int[][] dp){
        if(idx == arr.length) return total;

        if(dp[idx][total] != -1) return dp[idx][total];

        int skip = func(idx+1, total, arr, dp);

        int take = total;
        if(arr[idx] > total) take = func(idx+1, total + arr[idx], arr, dp);

        return dp[idx][total] = Math.max(skip, take); 
    }
}