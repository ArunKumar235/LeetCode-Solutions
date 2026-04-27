class Solution {
    public int maxProduct(int[] nums) {
        int p = 1, s = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            p *= nums[i];
            s *= nums[nums.length-1-i];
            max = Math.max(p, Math.max(s, max));
            if(p==0) p = 1;
            if(s==0) s = 1;
        }
        return max;
    }
}