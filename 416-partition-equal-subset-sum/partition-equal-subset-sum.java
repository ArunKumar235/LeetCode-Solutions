class Solution {
    public boolean canPartition(int[] nums) {
        int tsum = 0;
        for(int num: nums) tsum+= num;
        if(tsum%2==1) return false;
        int target = tsum/2;

        int[][] dp = new int[nums.length][target+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }                

        return rec(nums.length-1, target, nums, dp);
    }

    private boolean rec(int idx, int target, int[] nums, int[][] dp){
        if(idx<0) return target==0;
        if(target==0) return true;
        if(target<0) return false;
        if(dp[idx][target] != -1) return dp[idx][target]==1;

        dp[idx][target] = (rec(idx-1,target,nums,dp) || rec(idx-1,target-nums[idx],nums,dp)) ? 1 : 0;

        return dp[idx][target]==1;
    }
}