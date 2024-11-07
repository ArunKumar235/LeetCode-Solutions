class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        
        for (int num : nums) {
            heap.offer((long) num);
        }
        
        int ans = 0;
        while (heap.peek() < k) {
            long x = heap.poll();
            long y = heap.poll();
            
            long new_value = Math.min(x, y) * 2 + Math.max(x, y);
            
            heap.offer(new_value);
            ans++;
        }
        
        return ans;
    }
}