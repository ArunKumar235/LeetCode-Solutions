class Solution {
    public int removeDuplicates(int[] nums) {
        int replace = 1;
        for(int i = 1; i<nums.length; i++){
            if(nums[i-1]!=nums[i]){
                nums[replace] = nums[i];
                replace++;
            }
        }
        return replace;
    }
}