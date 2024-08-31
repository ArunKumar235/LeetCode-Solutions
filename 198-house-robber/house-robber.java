class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int rob(int[] nums) {
        return helper(nums, 0);
    }

    public int helper(int[] nums, int index){
        if(index>=nums.length) return 0;
        if(memo.containsKey(index)) return memo.get(index);
        int result = Math.max(nums[index]+helper(nums, index+2), helper(nums, index+1));
        memo.put(index, result);
        return result;
    }
}