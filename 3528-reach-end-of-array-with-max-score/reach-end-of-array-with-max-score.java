class Solution {

    public long findMaximumScore(List<Integer> nums) {
        long max = 0, sum = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            sum += max = Math.max(max, nums.get(i));
        }
        return sum;
    }
}