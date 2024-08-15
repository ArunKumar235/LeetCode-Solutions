class Solution {
    public int missingNumber(int[] nums) {

        sort(nums, nums.length);
        System.out.println(Arrays.toString(nums));
        for(int i = 0; i<nums.length; i++){
            if(nums[i]!=i) return i;
        }
        return nums.length;
    }

    public void sort(int[] arr, int n){
        //Cycle Sort
        int i = 0; 
        while(i<n){
            int j = arr[i];
            if(j<n && arr[i]!=arr[j]){
                swap(arr,i,j);
            }else{
                i++;
            }
        }
    }

    public void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}