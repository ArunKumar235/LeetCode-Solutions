class Solution {
    public int majorityElement(int[] nums) {
        // treat as two elements, majority ele, non majority ele
        int ctr = 0;
        int e = 0;
        for(int i = 0; i<nums.length; i++){
            if(ctr==0){
                e = nums[i];
                ctr=1;
            }
            else if(e==nums[i]){
                ctr++;
            }
            else{
                ctr--;
            }
        }
        return e;
    }
}