class Solution {
    public int missingNumber(int[] nums) {
        //Cycle Sort
        int i = 0; 
        int n = nums.length;
        while(i<n){
            int j = nums[i];
            if(j<n && nums[i]!=nums[j]){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }else{
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        for(int k = 0; k<nums.length; k++){
            if(nums[k]!=k) return k;
        }
        return nums.length;
    }
}