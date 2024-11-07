class Solution {
    public int longestNiceSubarray(int[] nums) {
        int res = 0;
        int left = 0;
        int right = 0;
        int used = 0;
        while (right < nums.length) {
            while ((used & nums[right]) != 0) {
                used ^= nums[left++];
            }
            used |= nums[right];
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}