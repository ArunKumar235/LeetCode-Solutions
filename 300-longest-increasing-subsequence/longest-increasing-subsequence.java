class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(nums[i] < nums[j]) dp[j] = Math.max(dp[j], dp[i]+1);
            }
        }
        
        int max = 1;
        for(int num: dp) max = Math.max(max, num);
        return max;
    }
}