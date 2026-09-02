class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros = 0;
        int ones = 0;

        int res = 0;

        int l = 0;
        for(int r = 0; r < nums.length; r++){
            if(nums[r] == 1) ones++;
            else zeros++;

            while(zeros > k){
                if(nums[l] == 0) zeros--;
                else ones--;
                l++;
            }
            res = Math.max(res, ones + zeros);
        }
        return res;
    }
}