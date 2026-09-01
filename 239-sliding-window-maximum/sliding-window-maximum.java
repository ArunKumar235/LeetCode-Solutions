class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        int[] res = new int[n - k + 1];

        // maintain decreasing order
        Deque<Integer> dq = new ArrayDeque<>();

        for(int r = 0; r<n; r++){
            // expired - remove from front
            while(!dq.isEmpty() && r - dq.peekFirst() >= k){
                dq.pollFirst();
            }
            // smaller than current - remove from back
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[r]){
                dq.pollLast();
            }

            dq.offerLast(r);
            
            if(r >= k-1) res[r-k+1] = nums[dq.peekFirst()];
        }
        return res;
    }
}