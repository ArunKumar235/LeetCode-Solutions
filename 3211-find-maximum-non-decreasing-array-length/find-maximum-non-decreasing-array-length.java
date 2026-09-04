class Solution {
    public int findMaximumLength(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];

        long[] prefixSums = new long[n + 1];
        for(int i = 1; i <= n; i++){
            prefixSums[i] = prefixSums[i - 1] + nums[i - 1];
        }

        // {cost, index}
        Deque<long[]> queue = new ArrayDeque<>();

        int prev = 0;

        for(int i = 1; i <= n; i++){

            while(!queue.isEmpty() && queue.peekFirst()[0] >= -prefixSums[i]){
                prev = (int) queue.pollFirst()[1];
            }

            dp[i] = dp[prev] + 1;

            long cost = -prefixSums[i] - (prefixSums[i] - prefixSums[prev]);

            while(!queue.isEmpty() && queue.peekLast()[0] <= cost){
                queue.pollLast();
            }

            queue.offerLast(new long[]{cost, i});
        }
        return dp[n];
    }
}