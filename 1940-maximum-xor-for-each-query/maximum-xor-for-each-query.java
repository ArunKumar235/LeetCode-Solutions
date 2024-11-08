class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int xor = 0;
        int maxval = (1<<maximumBit)-1;
        int[] res = new int[n];
        for(int num: nums){
            xor ^= num;
        }
        for(int i = 0 ;i<n; i++){
            res[i] = xor ^ maxval;
            xor ^= nums[n-1-i];
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