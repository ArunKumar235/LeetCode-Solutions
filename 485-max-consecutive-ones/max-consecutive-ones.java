class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = -1;
        int res = 0;
        for(int right = 0; right<nums.length; right++){
            if(nums[right]==0){
                left = right;
            }else{
                res = Math.max(res, right-left);
            }
        }
        return res;
    }
}