class Solution {
    public int findDuplicate(int[] nums) {
        boolean[] ispresent = new boolean[nums.length + 1];
        for(int i: nums){
            if(ispresent[i]){
                return i;
            }
            ispresent[i] = true;
        }
        return -1;
    }
}