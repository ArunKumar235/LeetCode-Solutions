class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        for(int i=0; i<n; i++){
            arr[i+1] = nums[i];
        }
        arr[0] = arr[n+1] = 1;
        int[][] dp = new int[n+2][n+2];
        for(int i =0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(arr, dp, 1, n);
    }

    public int solve(int[] arr, int[][] dp, int left, int right){
        if(left>right){
            return 0;
        }
        if(dp[left][right]!=-1){
            return dp[left][right];
        }
        int maxPoints = -1;
        for(int index = left; index<=right; index++){
            maxPoints = Math.max(maxPoints, solve(arr, dp, left, index-1)+solve(arr, dp, index+1 ,right) + arr[left-1]*arr[index]*arr[right+1]);
        }
        dp[left][right] = maxPoints;
        return maxPoints;
    }
}