class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] len = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(len, 1);
        Arrays.fill(cnt, 1);

        int maxLen = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<i; j++){
                if(nums[j]<nums[i]){
                    if(len[i] < len[j]+1)
                    {
                        len[i] = len[j]+1;
                        cnt[i] = 0;
                    }
                    if(len[i] == len[j]+1)
                    {
                        cnt[i] += cnt[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, len[i]);
        }

        int res = 0;
        for(int i = 0; i<n; i++){
            if(len[i] == maxLen){
                res += cnt[i];
            }
        }
        
        return res;
    }
}