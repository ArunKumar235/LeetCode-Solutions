class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for(int num: nums) total+=num;

        int k = (total-target)/2;

        if((total-target)<0 || (total-target)%2==1) return 0;
        
        // count subsets with sum k

        int[] prev = new int[k+1];
        int[] curr = new int[k+1];

        if(nums[0]==0) prev[0] = 2;
        else prev[0] = 1;

        if(nums[0]!=0 && nums[0]<=k) prev[nums[0]] = 1;

        for(int i = 1; i<nums.length; i++){
            for(int j = 0; j<=k; j++){
                int nottake = prev[j];
                int take = 0;
                if(j-nums[i]>=0) take = prev[j-nums[i]];

                curr[j] = nottake+take;
            }
            prev = curr;
            curr = new int[k+1];
        }

        return prev[k];
    }
}
