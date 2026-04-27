class Solution {
    public void nextPermutation(int[] nums) {
        int i1 = -1;
        int i2 = -1;
        int n = nums.length;
        for(int i = n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                i1 = i;
                break;
            }
        }   
        if(i1==-1){
            reverse(nums, 0);
            return;
        }
        for(int i = n-1; i>i1; i--){
            if(nums[i1]<nums[i]){
                i2 = i;
                break;
            }
        }
        swap(nums, i1, i2);
        reverse(nums, i1+1);
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    private static void reverse(int[] nums, int s){
        int e = nums.length-1;
        while(s<e){
            swap(nums, s++, e--);
        }
    }
}