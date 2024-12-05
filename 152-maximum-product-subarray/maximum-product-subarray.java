class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            prefix *= nums[i];
            suffix *= nums[nums.length-i-1];

            res = Math.max(res, Math.max(prefix, suffix));
            if(prefix==0) prefix++;
            if(suffix==0) suffix++;
        }
        return res;
    }
}