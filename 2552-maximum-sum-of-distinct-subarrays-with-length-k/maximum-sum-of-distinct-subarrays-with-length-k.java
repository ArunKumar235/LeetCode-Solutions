class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        long res = 0;
        long currSum = 0;
        int left = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int right = 0; right < nums.length; right++) {

            while (set.contains(nums[right])) {
                currSum -= nums[left];
                set.remove(nums[left++]);
            }

            set.add(nums[right]);
            currSum += nums[right];

            if (right - left + 1 == k) {
                res = Math.max(res, currSum);
                set.remove(nums[left]);
                currSum -= nums[left++];
            }

        }

        return res;
    }
}