class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int R = maze.length;
        int C = maze[0].length;

        maze[entrance[0]][entrance[1]] = '+';

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{entrance[0], entrance[1], 0});
        
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            int move = q.peek()[2];
            q.poll();
            if((r!=entrance[0] || c!=entrance[1]) && (r==0 || c==0 || r==R-1 || c==C-1)){
                return move;
            }

            int[][] moves = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

            for(int[] arr: moves){
                int newr = r+arr[0];
                int newc = c+arr[1];

                if(!(newr<0 || newc<0 || newr>=R || newc>=C) && maze[newr][newc]=='.'){
                    maze[newr][newc] = '+';
                    q.add(new int[]{newr, newc, move+1});
                }
            }
        }

        return -1;
    }
}