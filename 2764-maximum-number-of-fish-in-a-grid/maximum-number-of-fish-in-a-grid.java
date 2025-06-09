class Solution {
    public int findMaxFish(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        int res = 0;
        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                if(grid[i][j] > 0) res = Math.max(res, dfs(i, j, grid, R, C));
            }
        }
        return res;
    }

    private int dfs(int x, int y, int[][] grid, int R, int C){
        if(x<0 || y<0 || x>=R || y>=C || grid[x][y]==0) return 0;

        int res = grid[x][y];

        grid[x][y] = 0;

        int[][] moves = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for(int[] move: moves){
            res += dfs(x+move[0], y+move[1], grid, R, C);
        } 

        return res;
    }
}