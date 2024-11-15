class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n-1;
        
        while(left+1<n && arr[left]<=arr[left+1]) left++;
        if(left==n-1) return 0;

        while(right-1>=0 && arr[right]>=arr[right-1]) right--;

        int start = 0;
        int end = right;
        int result = Math.min(n-left-1, right);
        
        while(start<=left && end<n){
            if(arr[start]<=arr[end]){
                result = Math.min(result, end-start-1);
                start++;
            }else{
                end++;
            }
        }
        return result;
    }
}