class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n];
        for(int[] arr: memo){
            Arrays.fill(arr, -1);
        }
        return func(0, -1, nums, memo);
    }

    private int func(int i, int prev, int[] nums, int[][] memo){
        if(i==nums.length) return 0;
        if(memo[i][prev+1] != -1) return memo[i][prev+1];

        int dontTake = func(i+1, prev, nums, memo);
        int take = 0;

        if(prev == -1 || nums[prev]<nums[i]){
            take = 1+ func(i+1, i, nums, memo);
        }

        return memo[i][prev+1] = Math.max(take, dontTake);
    }
}