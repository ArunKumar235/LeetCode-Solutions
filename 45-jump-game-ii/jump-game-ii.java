class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        return rec(nums, dp, 0);
    }

    private int rec(int[] arr, int[] dp, int idx){
        if(idx>=arr.length-1) return 0;
        if(arr[idx]==0) return 10000; // safe max value
        if(dp[idx] != Integer.MAX_VALUE) return dp[idx];
        
        for(int i = 1; i<=arr[idx]; i++){
            dp[idx] = Math.min(dp[idx], 1 + rec(arr, dp, idx+i));
        } 
        return dp[idx];
    }
}