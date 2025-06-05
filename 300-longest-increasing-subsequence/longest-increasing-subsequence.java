class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n];
        for(int[] arr: memo){
            Arrays.fill(arr, -1);
        }
        return func(0, 0, nums, memo);
    }

    private int func(int idx, int prev, int[] nums, int[][] memo){
        if(idx==nums.length) return 0;

        if(memo[idx][prev]!=-1) return memo[idx][prev];

        int len = func(idx+1, prev, nums, memo);

        if(prev==0 || nums[idx]>nums[prev-1]) {
            len = Math.max(len, 1 + func(idx+1, idx+1, nums, memo));
        } 

        return memo[idx][prev] = len;
    }
}