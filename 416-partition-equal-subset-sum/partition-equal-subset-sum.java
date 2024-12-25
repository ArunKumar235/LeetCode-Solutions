class Solution {
    public boolean canPartition(int[] nums) {
        int N = nums.length;

        int totalSum = 0;
        for(int num: nums){
            totalSum += num;
        }

        if(totalSum %2 == 1) return false;
        int target = totalSum/2;
        
        boolean[] prev = new boolean[target+1];
        
        if(nums[0] <= target) prev[nums[0]] = true;
        prev[0] = true;

        for(int idx = 1; idx<N; idx++){
            boolean[] curr = new boolean[target+1];
            curr[0] = true;
            for(int t = 1; t<=target; t++){
                boolean notTake = prev[t];
                boolean take = false;
                if(nums[idx] <= t) take = prev[t - nums[idx]];

                curr[t] = take || notTake;
            }
            prev = curr;
        }

        return prev[target];
    }
}