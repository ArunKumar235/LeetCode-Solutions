class Solution {
    public long minOperations(int[] nums) {
        long res = 0;
        long prevX = 0;
        long currX = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] + prevX < nums[i]){
                currX = 0;
            }else{
                currX = (nums[i-1] + prevX) - nums[i];
            }
            if(currX > prevX){
                res += currX - prevX;
            }
            prevX = currX;
            currX = 0;
        }
        return res;
    }
}

// 7 6 5 8 6 2 1
// 0
// +1 7
// +2 7
// +0 8
// +2 8
// +6 8
// +7 8

// 0 1 1 0 2 4 1