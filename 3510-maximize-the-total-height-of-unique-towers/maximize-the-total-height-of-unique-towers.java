class Solution {
    public long maximumTotalSum(int[] max) {
        Arrays.sort(max);
        int n = max.length;
        long sum = 0;
        int val = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            val = Math.min(val - 1, max[i]);
            if (val <= 0) {
                return -1;
            }
            sum += val;
        }

        return sum;
    }
}