class Solution {
    public boolean exist(char[][] board, String word) {
        int R = board.length;
        int C = board[0].length;
        boolean[][] visited = new boolean[R][C];

        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(word, board, i, j, 0, visited)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(String word, char[][] board, int i, int j, int idx, boolean[][] visited){
        if(idx==word.length()) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return false;
        if(visited[i][j]) return false;
        if(board[i][j]!=word.charAt(idx)) return false;
        visited[i][j] = true;
        boolean res = dfs(word, board, i+1, j, idx+1, visited) || 
            dfs(word, board, i, j+1, idx+1, visited) || 
            dfs(word, board, i-1, j, idx+1, visited) ||
            dfs(word, board, i, j-1, idx+1, visited);
        visited[i][j] = false;
        return res;
    }
}