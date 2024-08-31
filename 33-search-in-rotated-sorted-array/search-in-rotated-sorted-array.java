class Solution {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target) return mid;
            if(nums[start]<=nums[mid]){
                if(target >= nums[start] && target<=nums[mid]){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }else if(target >= nums[mid] && target<=nums[end]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;


        // int len = nums.length-1;
        // int pivot = findPivot(0, len, nums);
        // int ans = binarySearch(0, pivot, nums, target);
        // return (ans!=-1) ? ans : binarySearch(pivot+1, len, nums, target);
    }

    public int findPivot( int start, int end, int[] nums){
        while(start<end){
            int mid = start + (end-start)/2;
            if(nums[mid]>nums[mid+1]) return mid;
            if(nums[mid]>=nums[start]) start = mid+1;
            else end = mid;
        }
        return start;
    }

    public int binarySearch(int start, int end, int[] nums, int target){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]<target) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }
}