class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j, 0});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int mins = 0;
        int[] rowDiff = new int[]{-1, 0, 1, 0};
        int[] colDiff = new int[]{0, 1, 0, -1};
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int min = curr[2];
            mins = Math.max(mins, min);
            for(int i = 0; i<4; i++){
                int newR = r + rowDiff[i];
                int newC = c + colDiff[i];
                if( 0 <= newR && newR < grid.length &&
                    0 <= newC && newC < grid[0].length &&
                    grid[newR][newC] == 1
                ){
                    q.offer(new int[]{newR, newC, min+1});
                    fresh--;
                    grid[newR][newC] = 2;
                }
            }
        }
        return fresh !=0 ? -1 : mins;
    }
}