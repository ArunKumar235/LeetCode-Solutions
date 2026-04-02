class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int prev1 = -1;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==1) {
                prev1 = i;
                while(i<nums.length && nums[i]==1){
                    i++;
                }
                res = Math.max(res, i-prev1);
            }
        }
        return res;
    }
}