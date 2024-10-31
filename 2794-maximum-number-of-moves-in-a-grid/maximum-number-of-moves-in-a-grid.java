class Solution {
    int m;
    int n;
    final int VISITED = -1;
    
    public int maxMoves(int[][] grid) {
        int res = 0;
        m = grid.length;
        n = grid[0].length;
        
        for (int row = 0; row < m; row++) {
            res = Math.max(res, dfs(grid, row, 0));
        }
        return res;
    }
    
    public int dfs(int [][] grid, int row, int col) {
        if (col == n - 1) {
            return col;
        }
        
        int val = grid[row][col];
        int res = col;
        if (grid[row][col + 1] > val) {
            res = dfs(grid, row, col + 1);
        }
        
        if (row + 1 < m && grid[row + 1][col + 1] > val) {
            res = Math.max(res, dfs(grid, row + 1, col + 1));
        }
        
        if (row - 1 >= 0 && grid[row - 1][col + 1] > val) {
            res = Math.max(res, dfs(grid, row - 1, col + 1));
        }
        
        grid[row][col] = VISITED;
        return res;
    }
}