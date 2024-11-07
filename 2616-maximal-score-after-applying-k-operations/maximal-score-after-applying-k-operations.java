class Solution {
    public long maxKelements(int[] nums, int k) {
        long ret = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for(int num : nums){
            pq.offer(num);
        }

        for(int i = 0; i < k; i++){
            int cur = pq.poll();
            ret += cur;
            pq.offer((int)(cur+2)/3);
        }

        return ret;
    }
}