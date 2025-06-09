class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        int res = 0;
        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                if(grid[i][j] == 1) res = Math.max(res, size(i, j, grid, R, C));
            }
        }
        return res;
    }

    private int size(int x, int y, int[][] grid, int R, int C){
        if(x<0 || x>=R || y<0 || y>=C || grid[x][y]==0) return 0;
        
        int res = grid[x][y];
        grid[x][y] = 0;

        int[][] moves = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for(int[] move: moves){
            res += size(x+move[0], y+move[1], grid, R, C);
        } 

        return res;
    }
}