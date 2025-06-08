class Solution {
    public boolean canMakeEqual(int[] nums, int k) {
        return Math.min(func(nums.clone(), 1), func(nums.clone(), -1)) <= k;
    }

    private int func(int[] arr, int target){
        int count = 0;
        for(int i = 0; i<arr.length-1; i++){
            if(arr[i] != target){
                arr[i] = -arr[i];
                arr[i+1] = -arr[i+1];
                count++;
            }
        }
        return (arr[arr.length-1]==target) ? count : Integer.MAX_VALUE;
    }
}