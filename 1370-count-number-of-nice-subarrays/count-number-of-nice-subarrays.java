class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    private int atMost(int[] nums, int k){
        int count = 0;
        int l = 0;
        for(int r = 0; r < nums.length; r++){
            if(nums[r] % 2 == 1) k--;

            while(k < 0){
                if(nums[l++] % 2 == 1) k++;
            }
            
            count += r - l;
        }
        return count;
    }
}