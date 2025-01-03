class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] ps = new long[n+1];
        for(int i = 0; i<n; i++){
            ps[i+1] = ps[i] + nums[i];
        }
        int res = 0;
        for(int i = 1; i<n; i++){
            if(ps[i] >= ps[n]-ps[i]) res++;
        }

        return res;
        
    }
}