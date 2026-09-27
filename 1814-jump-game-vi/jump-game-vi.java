class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;

        int[] dp = new int[n];

        Deque<Integer> dq = new ArrayDeque<>();

        for(int r = 0; r < n; r++){
            // remove invalid steps
            while(!dq.isEmpty() && r - dq.peekFirst() > k){
                dq.pollFirst();
            }
            
            dp[r] = nums[r];
            if(!dq.isEmpty()) dp[r] += dp[dq.peekFirst()];

            // maintain dec order
            while(!dq.isEmpty() && dp[dq.peekLast()] <= dp[r]){
                dq.pollLast();
            }
            dq.offerLast(r);
        }
        return dp[n-1];
    }
}

// 1, -1, -2, 4, -7, 3
// 1,  0, -1, 4, -3, 7