class Solution {
    public boolean canPartition(int[] nums) {
        int tsum = 0;
        for(int num: nums) tsum+= num;
        if(tsum%2==1) return false;
        int target = tsum/2;

        boolean[] prev = new boolean[target+1];
        boolean[] curr = new boolean[target+1];
        prev[0] = true;
        curr[0] = true;
        if(nums[0]<=target) curr[nums[0]] = true;

        for(int i = 1; i<nums.length; i++){
            curr[0] = true;
            if(nums[i]<=target) curr[nums[i]] = true;
            for(int t = 1; t<=target; t++){
                if(t-nums[i] >=0) curr[t] = prev[t] || prev[t-nums[i]];
                else curr[t] = prev[t];
            }
            prev = curr;
            curr = new boolean[target+1];
        }

        // for(int i = 0; i<=target; i++){
        //     System.out.println(i+ " " +prev[i]);
        // }
        return prev[target];
    }
}