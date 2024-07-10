class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        for(int i = 1; i<nums.length; i++){
            if(nums[i-1]>nums[i]){
                count++;
            }
        }
        if(count==0){
            return true;
        }if(count>1){
            return false;
        }if(nums[0]>=nums[nums.length-1]){
            return true;
        }return false;
    }
}