class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal-1);
    }
    
    // number of subarrays with sum at most equal to goal
    private int atMost(int[] nums, int goal){
        int res = 0;

        int l = 0;
        int sum = 0;
        for(int r = 0; r < nums.length; r++){
            sum += nums[r];

            while(l <= r && sum > goal){
                sum -= nums[l++];
            }
            res += r - l + 1;
        }
        return res;
    }
}