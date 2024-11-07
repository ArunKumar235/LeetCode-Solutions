class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: nums){
            pq.offer((long)num);
        }
        long res = 0;
        for(int i = 0; i<k; i++){
            Long val = pq.poll();
            res += val;
            pq.offer((val+2)/3);
        }
        return res;
    }
}