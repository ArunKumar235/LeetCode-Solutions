class Solution {
    public int minPathSum(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;

        int[] prev = new int[c];
        for(int i = 0; i<r; i++){
            int[] curr = new int[c];
            for(int j = 0; j<c; j++){
                curr[j] = arr[i][j];
                if(i>0 && j>0) curr[j] += Math.min(curr[j-1], prev[j]);
                else if(i>0) curr[j] += prev[j];
                else if(j>0) curr[j] += curr[j-1]; 
            }
            prev = curr;
        }
        return prev[c-1];
    }
}