class Solution {
    public int[] twoSum(int[] nums, int target) {

        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i]+nums[j]==target){
                    int[] li = new int[]{i,j};
                    return li;
                }
            }
        }
        return new int[]{-1, -1};
    }
}