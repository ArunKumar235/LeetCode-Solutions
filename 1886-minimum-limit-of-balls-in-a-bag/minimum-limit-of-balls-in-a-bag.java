class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int max = nums[0];
        for(int num: nums) max = Math.max(max, num);
        
        int l = 1;
        int r = max;

        while(l<r){
            int mid = l + (r-l)/2;
            if(check(nums, maxOperations, mid)){ 
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return r;
    }

    private boolean check(int[] nums, int maxOps, int maxBalls){
        int ops = 0;
        for(int num: nums){
            ops += Math.ceil(num / (double) maxBalls) - 1;
            
            if(ops > maxOps) return false;
        }
        return true;
    }
}