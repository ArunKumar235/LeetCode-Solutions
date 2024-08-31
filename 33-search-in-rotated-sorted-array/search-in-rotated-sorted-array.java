class Solution {
    public int search(int[] nums, int target) {

        // int start = 0;
        // int end = nums.length-1;
        // while(start<=end){
        //     int mid = start + (end-start)/2;
        //     if(nums[mid]==target) return mid;
        //     if(nums[start]<=nums[mid]){
        //         if(target >= nums[start] && target<=nums[mid]){
        //             end = mid-1;
        //         }else{
        //             start = mid+1;
        //         }
        //     }else if(target >= nums[mid] && target<=nums[end]){
        //         start = mid+1;
        //     }else{
        //         end = mid-1;
        //     }
        // }
        // return -1;

        return search(nums, 0, nums.length-1, target);
        
    }

    public int search(int[] arr, int start, int end, int target){
        if(start>end) return -1;
        int mid = start + (end-start)/2;
        if(arr[mid]==target) return mid;
        if(arr[start]<=arr[mid]){
            if((target >= arr[start] && target <= arr[mid])){
                return search(arr, start, mid-1, target);
            }
            return search(arr, mid+1, end, target);
        }
        if(target>=arr[mid] && target<=arr[end]) return search(arr, mid+1, end, target);
        return search(arr, start, mid-1, target);
    }
}