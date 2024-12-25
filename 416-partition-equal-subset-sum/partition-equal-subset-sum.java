class Solution {
    public boolean canPartition(int[] nums) {
        int N = nums.length;

        int totalSum = 0;
        for(int num: nums){
            totalSum += num;
        }

        if(totalSum %2 == 1) return false;
        int target = totalSum/2;
        boolean[][] dp = new boolean[N][target +1];
        for(int i = 0; i<N; i++){
            dp[i][0] = true;
        }
        if(nums[0] <= target) dp[0][nums[0]] = true;

        for(int idx = 1; idx<N; idx++){
            for(int t = 1; t<=target; t++){
                boolean notTake = dp[idx-1][t];
                boolean take = false;
                if(nums[idx] <= t) take = dp[idx-1][t - nums[idx]];

                dp[idx][t] = take || notTake;
            }
        }

        return dp[N-1][target];
    }
}