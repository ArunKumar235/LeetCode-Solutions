class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0] = nums[0]; 
        dp[1] = Math.max(nums[1], dp[0]);
        return rec(nums.length-1, dp, nums);
    }

    private int rec(int idx, int[] dp, int[] nums){
        if(dp[idx] != -1) return dp[idx];
        dp[idx] = Math.max(nums[idx], rec(idx-1, dp, nums));
        dp[idx] = Math.max(dp[idx], rec(idx-2, dp, nums) + nums[idx]);    
        return dp[idx];
    }
}