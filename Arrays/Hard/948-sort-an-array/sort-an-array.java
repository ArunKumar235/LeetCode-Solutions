class Solution {
    public int[] sortArray(int[] nums) {
        split(nums,0,nums.length -1);
        return nums;
    }
    public void split(int[] nums, int l, int r){
        if (l < r) {
            int m = l + (r-l)/2;
            split(nums,l,m);
            split(nums,m+1,r);
        
        merge(nums,l,m,r);
        }
    }
    public void merge(int[] nums, int l,int m, int r){
        int[] left = new int[m-l+1];
        int[] right = new int[r-m];

        for(int i = 0 ;i<left.length; i++){
            left[i] = nums[l+i];
        }
        for(int i = 0; i<right.length; i++){
            right[i] = nums[m+i+1];
        }
        int i = 0, j = 0, k = l;
        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                nums[k++] = left[i++];
            }else{
                nums[k++] = right[j++];
            }
        }
        while(i<left.length){
            nums[k++] = left[i++];
        }
        while(j<right.length){
            nums[k++] = right[j++];
        }
    }
}