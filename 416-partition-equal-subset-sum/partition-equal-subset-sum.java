class Solution {
    public boolean canPartition(int[] nums) {
        int tsum = 0;
        for(int num: nums) tsum+= num;
        if(tsum%2==1) return false;
        int target = tsum/2;

        boolean[][] dp = new boolean[nums.length][target+1];
        for(int i = 0; i<nums.length; i++){
            dp[i][0] = true;
            if(nums[i]<=target) dp[i][nums[i]] = true;
        }

        for(int i = 1; i<nums.length; i++){
            for(int t = 1; t<=target; t++){
                dp[i][t] = dp[i-1][t];
                if(t-nums[i] >=0) dp[i][t] = dp[i-1][t] || dp[i-1][t-nums[i]];
            }
        }

        return dp[nums.length-1][target];
    }
}