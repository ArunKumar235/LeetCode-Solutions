class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for(int i = 1; i<n; i++){
            hash[i] = i;
            for(int j = 0; j<i; j++){
                if(nums[j] < nums[i]){
                    if(1+dp[j] > dp[i]) hash[i] = j;
                    dp[i] = Math.max(dp[i], 1+dp[j]);
                }
            }
            res = Math.max(res, dp[i]);
        }

        int start = -1;
        for(int i = 0; i<n; i++){
            if(dp[i]==res){
                start = i;
                break;
            }
        }
        List<Integer> li = new ArrayList<>();
        while(hash[start]!=start){
            li.add(nums[start]);
            start = hash[start];
        }
        li.add(nums[start]);
        Collections.reverse(li);
        System.out.println(li);
        return res;
    }
}