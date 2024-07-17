class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0; int j = 1;
        
        for(int num : nums){
            if(num >= 0 && i < nums.length) {
                ans[i] = num;
                i += 2;
            }
            else if (num < 0 && j < nums.length){
                ans[j] = num;
                j+= 2;
            }
        }
        
        return ans;
    }
}