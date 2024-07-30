class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        flip(nums,0,nums.length-1);
        flip(nums,k,nums.length-1);
        flip(nums,0,k-1);
    }

    public static void flip(int[] nums, int i, int j){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}