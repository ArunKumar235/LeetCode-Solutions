class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);
        int ans1[] = new int[nums.length-1];
        ans1[0] = nums[0];
        ans1[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i<ans1.length; i++){
            ans1[i] = Math.max(ans1[i-1], nums[i]+ans1[i-2]);
        } 
        int ans2[] = new int[nums.length-1];
        ans2[0] = nums[1];
        ans2[1] = Math.max(nums[1],nums[2]);
        for(int i = 2; i<ans2.length; i++){
            ans2[i] = Math.max(ans2[i-1], nums[i+1]+ans2[i-2]);
        }

        return Math.max(ans1[ans1.length-1], ans2[ans2.length-1]);
    }
}