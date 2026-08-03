class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c, char[][] grid){
        int[] rowDiff = new int[]{-1, 0, 1, 0};
        int[] colDiff = new int[]{0, 1, 0, -1};

        grid[r][c] = '0';

        for(int i = 0; i<4; i++){
            int newR = r + rowDiff[i];
            int newC = c + colDiff[i];

            if( 0 <= newR && newR < grid.length && 
                0 <= newC && newC < grid[0].length &&
                grid[newR][newC] == '1'
            )
                dfs(newR, newC, grid);
        }
    }
}