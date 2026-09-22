class Solution {
    int res = 0;
    int maxOR = 0;
    public int countMaxOrSubsets(int[] nums) {
        for(int num: nums) maxOR |= num;

        backtrack(0, nums, 0);

        return res;
    }

    private void backtrack(int idx, int[] nums, int currOR){
        if(currOR == maxOR) res++;

        for(int i = idx; i < nums.length; i++){
            backtrack(i+1, nums, currOR | nums[i]);
        }
    }
}