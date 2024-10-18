class Solution {
    private int ans = 0;
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        for(int i: nums){
            maxOR |= i;
        }
        backtrack(nums, 0, 0, maxOR);
        return ans;
    }

    public void backtrack(int[] nums, int pos, int orVal, int maxOR){
        if(orVal==maxOR){
            ans++;
        }
        for(int i = pos; i<nums.length; i++){
            backtrack(nums, i+1, orVal|nums[i], maxOR);
        }
    }
}