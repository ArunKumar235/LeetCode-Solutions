class Solution {
    public boolean canPartition(int[] nums) {
        int N = nums.length;

        int totalSum = 0;
        for(int num: nums){
            totalSum += num;
        }

        if(totalSum %2 == 1) return false;

        int[][] dp = new int[N][totalSum/2 +1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        return rec(N-1, totalSum/2, nums, dp);
    }

    private boolean rec(int idx, int target, int[] nums, int[][] dp){
        if(idx==0) return nums[0] == target;
        if(target==0) return true;
        if(dp[idx][target] != -1) return dp[idx][target] == 1;

        boolean notTake = rec(idx-1, target, nums, dp);
        boolean take = false;
        if(nums[idx] <= target) take = rec(idx-1, target - nums[idx], nums, dp);

        dp[idx][target] = (take || notTake) ? 1 : 0;

        return dp[idx][target] == 1;
    }
}