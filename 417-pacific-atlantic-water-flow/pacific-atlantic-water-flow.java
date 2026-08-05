class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int R = heights.length;
        int C = heights[0].length;
        boolean[][] pacific = new boolean[R][C];
        boolean[][] atlantic = new boolean[R][C];
        boolean[][] visited = new boolean[R][C];

        for(int i = 0; i<R; i++){
            dfs(i, 0, pacific, visited, heights);
        }
        for(int i = 0; i<C; i++){
            dfs(0, i, pacific, visited, heights);
        }
        visited = new boolean[R][C];
        for(int i = 0; i<R; i++){
            dfs(i, C-1, atlantic, visited, heights);
        }
        for(int i = 0; i<C; i++){
            dfs(R-1, i, atlantic, visited, heights);
        }
        List<List<Integer>> li = new ArrayList<>();
        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    li.add(Arrays.asList(i, j));
                }
            }
        }
        return li;
    }

    private void dfs(int r, int c, boolean[][] ocean, boolean[][] visited, int[][] heights){
        visited[r][c] = true;
        ocean[r][c] = true;

        int[] rowDiff = new int[]{-1, 0, 1, 0};
        int[] colDiff = new int[]{0, 1, 0, -1};

        for(int i = 0; i<4; i++){
            int newR = r + rowDiff[i];
            int newC = c + colDiff[i];

            if( 0 <= newR && newR < ocean.length &&
                0 <= newC && newC < ocean[0].length &&
                heights[r][c] <= heights[newR][newC] &&
                !visited[newR][newC]
            )
                dfs(newR, newC, ocean, visited, heights);
        }
    }
}