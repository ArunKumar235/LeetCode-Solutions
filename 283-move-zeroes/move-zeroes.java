class Solution {
    public void moveZeroes(int[] nums) {
        int zi = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]!=0){
                nums[zi] = nums[i];
                if(zi!=i) nums[i] = 0;
                zi++;
            }
        }
    }
}