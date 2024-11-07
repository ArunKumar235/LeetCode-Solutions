class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add((long) num);
        }

        int count = 0;
        while (pq.peek() < k && pq.size() > 1) {

            long x = pq.poll();
            long y = pq.poll();

            count++;
            long new_Num = x * 2 + y;
            pq.add(new_Num);

        }
        return count;
    }
}