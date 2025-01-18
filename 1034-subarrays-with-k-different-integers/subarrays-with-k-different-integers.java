class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1); // {<=K} - {<=(K-1)} -> {==K}
    }

    // Returns the count of all subarrays with <=K unique elements
    private int helper(int[] nums, int k) { 
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, l = 0;

        for (int r = 0; r < nums.length; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            res += (r - l + 1); // Count of subarrays ending at r, and starting anywhere from l to r
        }
        return res;
    }
}
