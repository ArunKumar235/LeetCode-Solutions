class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int num: nums) total+=num;

        int k = (total-target)/2;

        if((total-target)<0 || (total-target)%2==1) return 0;
        
        // count subsets with sum k

        int[][] dp = new int[nums.length][k+1];

        if(nums[0]==0) dp[0][0] = 2;
        else dp[0][0] = 1;

        if(nums[0]!=0 && nums[0]<=k) dp[0][nums[0]] = 1;

        for(int i = 1; i<nums.length; i++){
            for(int j = 0; j<=k; j++){
                int nottake = dp[i-1][j];
                int take = 0;
                if(j-nums[i]>=0) take = dp[i-1][j-nums[i]];

                dp[i][j] = nottake+take;
            }
        }

        return dp[nums.length-1][k];
    }
}
