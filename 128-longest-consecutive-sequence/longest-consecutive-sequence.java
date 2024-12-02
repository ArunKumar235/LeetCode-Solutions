class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int smallest = nums[0];
        int count = 1;
        int longest = 1;
        for(int i = 1; i<nums.length; i++){
            if(nums[i]==smallest+1){
                smallest = nums[i];
                count++;
            }else if(nums[i]!=smallest){
                count = 1;
                smallest = nums[i];
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
}