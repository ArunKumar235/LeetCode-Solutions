class Solution {
    public int minCapability(int[] nums, int k) {
        int l = 1;
        int r = Arrays.stream(nums).max().getAsInt();
        while(l<r){
            int m = l + (r-l)/2;
            if(ispossible(m, nums, k)){
                r = m;
            }else{
                l = m+1;
            }
        }
        return r;
    }

    public boolean ispossible(int m, int[] nums, int k){
        int i = 0;
        while(i<nums.length){
            if(nums[i]<=m){
                i+=2;
                k--;
            }else{
                i++;
            }
            if(k==0) return true;
        }
        return false;
    }
}