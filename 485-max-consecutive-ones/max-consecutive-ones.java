class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr = 0;
        int max = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==0){
                max = Math.max(max,curr);
                curr = 0;
            }else{
                curr++;
            }
        }
        return Math.max(max,curr);
    }
}