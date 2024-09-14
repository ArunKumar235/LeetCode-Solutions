class Solution {
    int[] rDiff = {-1, 1, 0, 0};
    int[] cDiff = { 0, 0,-1, 1};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int r = grid.size();
        int c = grid.get(0).size();
        int[][] visited = new int[r][c];
        Queue<Cell> queue = new ArrayDeque<>();
        queue.add(new Cell(0,0,health-grid.get(0).get(0)));

        while(!queue.isEmpty()){
            Cell current = queue.poll();
            int row = current.row;
            int col = current.col;
            int hel = current.health;
            
            if(row==r-1 && col==c-1 && hel>0){
                return true;
            }
            for(int i = 0; i<4; i++){
                int newRow = row+rDiff[i];
                int newCol = col+cDiff[i];
                if(newRow>=0 && newRow<r && newCol>=0 && newCol<c){
                    int newHealth = hel-grid.get(newRow).get(newCol);
                    if(newHealth > 0 && newHealth>visited[newRow][newCol]){
                        visited[newRow][newCol] = newHealth;
                        queue.add(new Cell(newRow, newCol, newHealth));
                    }
                }
            }
        }
        return false;
    }
}

class Cell{
    int row, col, health;
    public Cell(int row, int col, int health){
        this.row = row;
        this.col = col;
        this.health = health;
    }
}