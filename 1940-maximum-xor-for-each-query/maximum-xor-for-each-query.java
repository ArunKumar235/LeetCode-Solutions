class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int xor = 0;
        int[] xors = new int[nums.length];
        
        for(int i = 0; i < n; i++){
            xor ^= nums[i];
            xors[n - i - 1] = xor;

            for(int bit = 0; bit < maximumBit; bit++){
                xors[n - i - 1] ^= (1<<bit); 
            }
        }
        return xors;
    }
}
// 3
// 0 1 0
// 1 0 1