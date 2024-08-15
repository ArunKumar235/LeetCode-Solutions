class Solution {
    public int missingNumber(int[] nums) {
        sort(nums, nums.length);
        System.out.println(Arrays.toString(nums));
        int i = 0;
        for(int a: nums){
            if(a!=i) return i;
            i++;
        }
        return i;
    }

    public void sort(int[] arr, int n){
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