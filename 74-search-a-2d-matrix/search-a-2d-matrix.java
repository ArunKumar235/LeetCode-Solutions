class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int start = 0;
        int end = r-1;
        while(start<end){
            int mid = start + (end-start)/2;
            if(matrix[mid][c - 1] == target){
                return true;
            }if(matrix[mid][c-1] > target){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        int first = 0;
        int last = c-1;
        while(first<=last){
            int mid = first + (last-first)/2;
            if(matrix[start][mid]==target){
                return true;
            }if(matrix[start][mid] > target){
                last = mid-1;
            }else{
                first = mid+1;
            }
        }

        return false;
    }
}