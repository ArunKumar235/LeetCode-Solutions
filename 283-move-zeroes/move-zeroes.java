class Solution {
    public void moveZeroes(int[] nums) {
        
        int replace = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[replace] = nums[i];
                replace++;
            }
        }
        for( ; replace<nums.length; replace++){
            nums[replace] = 0;
        }
        
    }
}