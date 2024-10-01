class Solution {
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] table = new int[r][c];
        int max = 0;
        for(int i = 0; i<r; i++){
            table[i][0] = matrix[i][0]-'0';
            max = Math.max(max, table[i][0]);
        }
        for(int j = 0; j<c; j++){
            table[0][j] = matrix[0][j] - '0';
            max = Math.max(max, table[0][j]);
        }
        for(int i = 1; i<r; i++){
            for(int j = 1; j<c; j++){
                if(matrix[i][j]=='0'){
                    table[i][j] = 0;
                }else{
                    table[i][j] = 1 + Math.min(table[i-1][j-1], Math.min(table[i-1][j], table[i][j-1]));
                }
                max = Math.max(max, table[i][j]);
            }
        }
        return max*max;
    }
}