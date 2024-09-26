class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int[][] arr = new int[image.length][image[0].length];
        for(int i = 0; i<arr.length; i++){
            for(int j = arr[0].length-1; j>=0; j--){
                arr[i][arr[0].length-1-j] = image[i][j]^1;
            }
        }
        return arr;
    }
}