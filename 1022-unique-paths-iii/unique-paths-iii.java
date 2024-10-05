class Solution {

    private int m;
    private int n;
    private int paths = 0;
    private boolean[][] visited;
    private int totalEmpty = 0;
    private int visitedEmpty = 0;

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int startRow = -1;
        int startColumn = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    startRow = i;
                    startColumn = j;
                } else if (grid[i][j] == 0) {
                    totalEmpty++;
                }
            }
        }
        uniquePathsIII(grid, startRow, startColumn);
        return paths;
    }

    private void uniquePathsIII(int[][] grid, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) return;
        int value = grid[r][c];
        if (value == -1) return;

        visited[r][c] = true;
        if (value == 0 || value == 1) {
            if (value == 0) visitedEmpty++;
            uniquePathsIII(grid, r + 1, c);
            uniquePathsIII(grid, r, c + 1);
            uniquePathsIII(grid, r - 1, c);
            uniquePathsIII(grid, r, c - 1);
        } else if (value == 2 && visitedEmpty == totalEmpty) {
            paths++;
        }
        visited[r][c] = false;
        if (value == 0) visitedEmpty--;
    }

}