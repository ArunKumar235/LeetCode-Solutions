class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        
        long[] prefix = new long[n + 1];
        for(int i = 0; i < n; i++){
            prefix[i + 1] = prefix[i] + nums[i];
        }
        
        int len = Integer.MAX_VALUE;
        
        Deque<Integer> dq = new ArrayDeque<>();

        for(int r = 0; r <= n; r++){
            // smallest prefix sum first to ensure max sum is obtained
            // maintain increasing prefix sums
            while(!dq.isEmpty() && prefix[r] <= prefix[dq.peekLast()]){
                dq.pollLast();
            }

            dq.offerLast(r);

            // valid subarray
            while(!dq.isEmpty() && prefix[r] - prefix[dq.peekFirst()] >= k){
                len = Math.min(len, r - dq.pollFirst());
            }
        }
        return len == Integer.MAX_VALUE ? -1 : len;
    }
}