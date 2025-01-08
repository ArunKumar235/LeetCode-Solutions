class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;

        int maxReachIdx = nums[0];
        int jump = 1;
        int steps = nums[0];

        for(int idx = 1; idx<n-1; idx++){
            if(idx+nums[idx] > maxReachIdx){
                maxReachIdx = idx+nums[idx];
            }

            steps--;

            if(steps==0){
                jump++;
                steps = maxReachIdx - idx;
            }
        }

        return jump;
    }
}