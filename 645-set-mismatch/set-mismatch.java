class Solution {
    public int[] findErrorNums(int[] nums) {
        int i = 0;
        while(i<nums.length){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }else{
                i++;
            }
        }
        for(int a = 0; a< nums.length; a++){
            if(nums[a]!=a+1) return new int[]{nums[a],a+1};
        }
        return new int[]{-1,-1};
    }
}