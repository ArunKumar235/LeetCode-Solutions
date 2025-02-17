class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return rec(nums, nums.length-1, dp);
    }

    private int rec(int[] nums, int idx, int[] dp){
        if(idx<0) return 0;
        if(dp[idx]!=-1) return dp[idx];
        return dp[idx] = Math.max(rec(nums, idx-1, dp), nums[idx]+rec(nums, idx-2, dp));
    }
}