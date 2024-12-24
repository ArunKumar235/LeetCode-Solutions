class Solution {
    public int minFallingPathSum(int[][] arr) {
        int r = arr.length;
        int[] prev = new int[r];
        for(int i = 0; i<r; i++){
            int[] curr = new int[r];
            for(int j = 0; j<r; j++){
                curr[j] = arr[i][j]; 
                if(i==0) continue;
                if(j>0 && j+1!=r) curr[j] += Math.min(prev[j-1], Math.min(prev[j], prev[j+1]));
                else if(j>0) curr[j] += Math.min(prev[j-1], prev[j]);
                else if(j+1!=r) curr[j] += Math.min(prev[j], prev[j+1]);
            }
            prev = curr;
        }
        int res = Integer.MAX_VALUE;
        for(int v: prev){
            res = Math.min(res, v);
        }
        return res;
    }
}