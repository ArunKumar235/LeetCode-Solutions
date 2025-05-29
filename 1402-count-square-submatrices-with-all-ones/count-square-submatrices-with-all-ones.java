class Solution {
    public int countSquares(int[][] matrix) {
        for(int i = 1; i<matrix.length; i++){
            for(int j = 1; j<matrix[0].length; j++){
                if(matrix[i][j]==1){
                    matrix[i][j] = 1 + Math.min(matrix[i-1][j], Math.min(matrix[i-1][j-1], matrix[i][j-1]));
                }
            }
        }
        int sum = 0;
        for(int[] arr: matrix){
            for(int i: arr) sum+=i;
        }

        return sum;
    }
}