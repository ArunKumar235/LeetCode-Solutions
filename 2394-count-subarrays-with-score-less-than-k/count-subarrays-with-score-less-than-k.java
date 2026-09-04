class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;

        long sum = 0;
        long ans = 0;

        int l = 0;
        for(int r = 0; r < n; r++){
            sum += nums[r];

            while(sum * (r - l + 1) >= k){
                sum -= nums[l++];
            }
            ans += r - l + 1;
        }
        return ans;
    }
}