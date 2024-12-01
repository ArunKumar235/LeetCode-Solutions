class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        while(left<=right && right<n){
            int val = nums[right];
            while((right+1)<n && nums[right]==nums[right+1]) right++;
            nums[left++] = nums[right++];
        }
        return left;
    }
}