class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[1], nums[0]);
        int prev1 = Math.max(nums[1], nums[0]);
        int prev2 = nums[0];

        for(int i = 2; i<n-1; i++){
            int curr = Math.max(prev1, nums[i]+prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        int ans1 = prev1;

        prev1 = Math.max(nums[2], nums[1]);
        prev2 = nums[1];

        for(int i = 3; i<n; i++){
            int curr = Math.max(prev1, nums[i]+prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return Math.max(ans1, prev1);
        
    }
}