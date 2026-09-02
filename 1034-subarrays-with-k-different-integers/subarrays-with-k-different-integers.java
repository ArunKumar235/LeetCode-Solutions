class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    // subarry count with atmost k different integers
    private int atMost(int[] nums, int k){
        Map<Integer, Integer> freq = new HashMap<>();

        int l = 0;
        int count = 0;
        int res = 0;
        for(int r = 0; r < nums.length; r++){
            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);
            if(freq.get(nums[r]) == 1) count++;

            while(count > k){
                freq.put(nums[l], freq.get(nums[l]) - 1);
                if(freq.get(nums[l]) == 0) count--;
                l++;
            }
            res += r - l + 1;
        }
        return res;
    }
}