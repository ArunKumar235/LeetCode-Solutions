class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return func(0, arr, k, dp);
    }

    private int func(int l, int[] arr, int k, int[] dp){
        if(l == arr.length) return 0;

        if(dp[l] != -1) return dp[l];

        int max = 0;
        int res = 0;
        for(int r = l; r < l + k && r < arr.length; r++){
            max = Math.max(max, arr[r]);

            res = Math.max(res, max * (r - l + 1) + func(r + 1, arr, k, dp));
        }

        return dp[l] = res;
    }
}