class Solution {
    public long maxKelements(int[] nums, int k) {
        long result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pq.offer(num);
        }
        for (int i = 0; i < k; i++) {
            int curr = pq.poll();
            result += curr;
            pq.add((int)(curr+2)/3);
        }
        return result;
    }
}