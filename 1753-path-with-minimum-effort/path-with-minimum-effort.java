class Solution {
    public int minimumEffortPath(int[][] heights) {
        int R = heights.length;
        int C = heights[0].length;

        boolean[][] visited = new boolean[R][C];

        int[][] moves = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // diff - r - c
        pq.offer(new int[]{0, 0, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            int diff = curr[0];
            int currR = curr[1];
            int currC = curr[2];

            visited[currR][currC] = true;

            if(currR == R-1 && currC == C-1) return diff;

            for(int[] move: moves){
                int newR = currR + move[0];
                int newC = currC + move[1];

                if(newR < 0 || R <= newR || newC < 0 || C <= newC) continue;
                if(visited[newR][newC]) continue;

                int newDiff = Math.max(diff, Math.abs(heights[newR][newC] - heights[currR][currC]));

                pq.offer(new int[]{newDiff, newR, newC});
            }
        }
        return -1;
    }
}