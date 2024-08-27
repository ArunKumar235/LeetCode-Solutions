class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr[] = new int[(nums1.length + nums2.length)/2 + 1];
        int n1 = nums1.length;
        int n2 = nums2.length;
        int a = arr.length;
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<n1 && j<n2 && k<a){
            if(nums1[i] < nums2[j]){
                arr[k++] = nums1[i++];
            }else{
                arr[k++] = nums2[j++];
            }
        }
        while(i<n1 && k<a){
            arr[k++] = nums1[i++];
        }
        while(j<n2 && k<a){
            arr[k++] = nums2[j++];
        }
        if((n1+n2) % 2 == 0){
            return (arr[a-1]+arr[a-2])/2.0;
        }
        return arr[arr.length-1];
    }
}