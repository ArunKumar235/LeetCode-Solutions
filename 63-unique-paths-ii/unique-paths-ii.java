class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;
        boolean b = true;
        if( r==0 || c==0 || arr[0][0]==1) return 0;
        for(int i = 1; i<r; i++){
            if(arr[i][0]==1){
                arr[i][0] = -1;
                b = false;
            }else if (b) arr[i][0] = 1;
        }
        b = true;
        for(int i = 1; i<c; i++){
            if(arr[0][i]==1){
                arr[0][i] = -1;
                b = false;
            }else if (b) arr[0][i] = 1;
        }
        arr[0][0] = 1;
        for(int i = 1; i<r; i++){
            for(int j = 1; j<c; j++){
                if(arr[i][j]==1){
                    arr[i][j] = -1;
                    continue;
                }
                if(arr[i-1][j] != -1) arr[i][j] += arr[i-1][j];
                if(arr[i][j-1] != -1) arr[i][j] += arr[i][j-1];
            }
        }
        // for(int[] i: arr){
        //     System.out.println(Arrays.toString(i));
        // }
        return arr[r-1][c-1] == -1 ? 0 : arr[r-1][c-1];
    }
}