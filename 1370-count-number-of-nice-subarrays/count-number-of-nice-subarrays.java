class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int l = 0;
        int count = 0;
        int res = 0;

        for(int r = 0; r<nums.length; r++){
            if(nums[r] % 2 == 1){
                k--;
                count = 0;
            }

            while(k == 0){
                if(nums[l] % 2 == 1){
                    k++;
                }
                l++;
                count++;
            }
            res += count;
        }
        return res;
    }
}