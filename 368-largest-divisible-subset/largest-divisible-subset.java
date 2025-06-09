class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> lds = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        
        for(int i = 1; i<n; i++){
            hash[i] = i;
            for(int j = 0; j<i; j++){
                if(nums[i]%nums[j]==0 && dp[i] < 1+dp[j]){
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
        }

        int ldsLen = -1;
        int idx = -1;
        for(int i = 0; i<n; i++){
            if(dp[i] > ldsLen){
                ldsLen = dp[i];
                idx = i;
            }
        }

        lds.add(nums[idx]);
        while(hash[idx]!=idx){
            idx = hash[idx];
            lds.add(nums[idx]);
        }

        return lds;
    }
}