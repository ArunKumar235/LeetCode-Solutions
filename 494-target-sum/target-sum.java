class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int num: nums) total+=num;

        int k = (total-target)/2;

        if((total-target)<0 || (total-target)%2==1) return 0;

        int[][] dp = new int[nums.length][k+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        
        return rec(nums.length-1, k, nums, dp);
    }
    // a+b = Tot
    // a-b = tar
    // Tot-b-b = tar

    // Tot = tar+2b
    // (Tot-tar)/2 = b

    // count subsets with sum k
    private int rec(int idx, int target, int[] nums, int[][] dp){
        if(idx==0){
            if(nums[0]==0 && target==0) return 2;
            if(nums[0]==target || target==0) return 1;
            return 0;
        }
        if(dp[idx][target]!=-1) return dp[idx][target];

        int notpick = rec(idx-1, target, nums, dp);
        int pick = Integer.MIN_VALUE; 
        if(target-nums[idx]>=0) pick = rec(idx-1, target-nums[idx], nums, dp);
        if(pick==Integer.MIN_VALUE) pick = 0;
        return dp[idx][target] = pick + notpick;
    }
}
