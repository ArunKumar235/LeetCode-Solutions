class Solution {
    public int minStoneSum(int[] piles, int k) {
        int maxValue = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: piles){
            pq.offer(num);
            maxValue += num;
        }
        for(int i = 0; i<k; i++){
            int val = pq.poll();
            maxValue -= val;
            maxValue += (val+1)/2;
            pq.offer((val+1)/2);
        }
        return maxValue;
    }
}