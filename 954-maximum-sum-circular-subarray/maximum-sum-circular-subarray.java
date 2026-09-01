class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0];
        int minSum = nums[0];

        int currMaxSum = 0;
        int currMinSum = 0;

        int total = 0;

        for(int i = 0; i<nums.length; i++){
            if(currMaxSum < 0) currMaxSum = 0;
            if(currMinSum > 0) currMinSum = 0;

            currMaxSum += nums[i];
            currMinSum += nums[i];

            maxSum = Math.max(maxSum, currMaxSum);
            minSum = Math.min(minSum, currMinSum);

            total += nums[i];
        }
        if(maxSum < 0) return maxSum;

        return Math.max(maxSum, total - minSum);
    }
}