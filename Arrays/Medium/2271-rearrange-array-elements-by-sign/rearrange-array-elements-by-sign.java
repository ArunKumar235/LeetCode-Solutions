class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos[] = new int[nums.length/2];
        int neg[] = new int[nums.length/2];
        int pi = 0;
        int ni = 0;
        for(int i: nums){
            if(i>0){
                pos[pi++] = i;
            }else{
                neg[ni++] = i;
            }
        }
        pi = 0;
        ni = 0;
        for(int i=0; i<nums.length; i+=2){
            nums[i] = pos[i/2];
            nums[i+1] = neg[i/2];
        }
        return nums;
    }
}