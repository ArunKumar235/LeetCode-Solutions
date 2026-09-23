class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        long minPositive = Long.MAX_VALUE;
        long minNegativeLoss = Long.MAX_VALUE;
        int positiveCount = 0;

        for (int num : nums) {
            long gain = (num ^ k) - num;

            if (gain > 0) {
                sum += num + gain;
                positiveCount++;
                minPositive = Math.min(minPositive, gain);
            } else {
                sum += num;
                minNegativeLoss = Math.min(minNegativeLoss, -gain);
            }
        }

        if (positiveCount % 2 == 1) {
            sum -= Math.min(minPositive, minNegativeLoss);
        }

        return sum;
    }
}
