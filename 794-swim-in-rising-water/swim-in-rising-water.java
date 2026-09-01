class Solution {
    public int swimInWater(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;

        int[][] moves = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        int[][] max = new int[R][C];
        for(int[] row: max) Arrays.fill(row, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{grid[0][0], 0, 0});
        max[0][0] = grid[0][0];

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currMax = curr[0];
            int currR = curr[1];
            int currC = curr[2];

            if(currR == R-1 && currC == C-1) return currMax;

            for(int[] move: moves){
                int newR = currR + move[0];
                int newC = currC + move[1];

                if(newR < 0 || R <= newR || newC < 0 || C <= newC ) continue;
                
                int newMax = Math.max(currMax, grid[newR][newC]);

                if(newMax >= max[newR][newC]) continue;

                pq.offer(new int[]{newMax, newR, newC});
                max[newR][newC] = newMax;
            }
        }
        return -1;
    }
}