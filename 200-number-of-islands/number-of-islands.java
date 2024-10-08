class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0 ;j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int r, int c){
        if(grid[r][c]=='0') return;
        int[] rowDiff = {-1, 0, 1,  0};
        int[] colDiff = { 0, 1, 0, -1};
        grid[r][c] = '0';
        for(int i = 0; i<4; i++){
            int rpos = r + rowDiff[i];
            int cpos = c + colDiff[i];
            if(rpos>=0 && rpos<grid.length && cpos>=0 && cpos<grid[0].length){
                if(grid[rpos][cpos]=='1') dfs(grid, rpos, cpos);
            }
        }
    }
}