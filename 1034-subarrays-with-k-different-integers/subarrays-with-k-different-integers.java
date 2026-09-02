class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        if(k > nums.length) return 0;
        return atMost(nums, k) - atMost(nums, k-1);
    }

    // subarry count with atmost k different integers
    private int atMost(int[] nums, int k){
        int[] freq = new int[nums.length + 1];

        int l = 0;
        int count = 0;
        int res = 0;
        for(int r = 0; r < nums.length; r++){
            freq[nums[r]]++;
            if(freq[nums[r]] == 1) count++;

            while(count > k){
                freq[nums[l]]--;
                if(freq[nums[l]] == 0) count--;
                l++;
            }
            res += r - l + 1;
        }
        return res;
    }
}