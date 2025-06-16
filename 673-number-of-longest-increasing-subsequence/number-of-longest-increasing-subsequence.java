class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);        
        
        int maxi = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){

                if(nums[i]>nums[j] && 1+dp[j]>dp[i]){
                    dp[i] = 1+dp[j];
                    cnt[i] = cnt[j];
                
                }else if(nums[j]<nums[i] && 1+dp[j] == dp[i]){
                    cnt[i] += cnt[j];
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }

        int nos =0;
    
        for(int i=0; i<n; i++){
            if(dp[i]==maxi) nos += cnt[i];
        }
        
        return nos;
    }
}