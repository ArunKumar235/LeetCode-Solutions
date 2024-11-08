class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] prefix = new int[nums.length];
        int xor = 0;
        for(int i = 0; i<nums.length; i++){
            xor ^= nums[i];
            prefix[i] = xor; 
        }
        int[] res = new int[nums.length];
        xor = (1<<maximumBit)-1;
        for(int i = 0; i<nums.length; i++){
            res[i] = xor^prefix[nums.length-1-i];
        }
        return res;
    }
}

// 0 1 0 3
// 3 2 3 0


//  0
//  1
// 01
// 10
// 11