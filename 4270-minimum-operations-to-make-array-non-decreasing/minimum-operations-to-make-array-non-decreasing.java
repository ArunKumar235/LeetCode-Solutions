class Solution {
    public long minOperations(int[] nums) {
        long res = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] > nums[i]){
                res += nums[i-1] - nums[i];
            }
        }
        return res;
    }
}
// 7 6 5 8 6 2 1
// 0 1 1 0 2 4 1