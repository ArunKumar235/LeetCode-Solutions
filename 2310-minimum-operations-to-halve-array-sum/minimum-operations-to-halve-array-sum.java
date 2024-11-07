class Solution {
    public int halveArray(int[] nums) {
        double maxSum = 0;
        double currSum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pq.offer((double) num);
            maxSum += num;
        }
        currSum = maxSum;
        int minOperations = 0;
        while (currSum > maxSum / 2.0) {
            double val = pq.poll() / 2.0;
            currSum -= val;
            pq.offer(val);
            minOperations++;
        }
        return minOperations;
    }
}