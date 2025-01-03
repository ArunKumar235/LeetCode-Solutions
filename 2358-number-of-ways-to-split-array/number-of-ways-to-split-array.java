class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long rightSum = 0;
        for(int i = 0; i<n; i++){
            rightSum += nums[i];
        }
        int res = 0;
        long leftSum = 0;
        for(int i = 0; i<n-1; i++){
            leftSum += nums[i];
            rightSum -= nums[i];
            if(leftSum >= rightSum) res++;
        }
        return res;
    }
}