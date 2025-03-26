class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int N = rooms.size();
        boolean[] visited = new boolean[N];
        
        dfs(0, rooms, visited);

        for(boolean v: visited){
            if(!v) return false;
        } 

        return true;
    }

    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited){
        visited[room] = true;
        for(int r: rooms.get(room)){
            if(!visited[r]) dfs(r, rooms, visited);
        }
    }
}