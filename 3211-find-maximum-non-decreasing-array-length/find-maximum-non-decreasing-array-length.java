class Solution {
    public int findMaximumLength(int[] nums) {
        int n = nums.length;

        long[] prefix = new long[n+1];
        for(int i = 1; i <= n; i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }

        int[] dp = new int[n+1];
        
        // threshold, idx
        // threshold tells us the minimum future prefix sum required before this index can be used as prev
        // maintain thresholds in increasing order
        Deque<long[]> dq = new ArrayDeque<>();

        int prev = 0;

        for(int r = 1; r <= n; r++){
            // if prefix[r] >= threshold then that candidate has become valid
            // because thresholds are increasing, all candidates that have become valid are at the front
            while(!dq.isEmpty() && dq.peekFirst()[0] <= prefix[r]){
                prev = (int) dq.pollFirst()[1];
            }

            dp[r] = dp[prev] + 1;

            // for some future idx next, to be valid
            // prefix[next] - prefix[r] >= prefix[r] - prefix[prev]
            // prefix[next] >= 2 * prefix[r] - prefix[prev]
            long threshold = 2 * prefix[r] - prefix[prev];
            
            // maintain threshold in increasing order
            while(!dq.isEmpty() && dq.peekLast()[0] >= threshold){
                dq.pollLast();
            }
            dq.offerLast(new long[]{threshold, r});
        }
        return dp[n];
    }
}