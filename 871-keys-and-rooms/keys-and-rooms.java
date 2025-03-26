class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int N = rooms.size();
        boolean[] visited = new boolean[N];
        visited[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int room: rooms.get(curr)){
                if(!visited[room]){
                    visited[room] = true;
                    q.add(room);
                }
            }
        }
        for(boolean v: visited){
            if(!v) return false;
        } 

        return true;
    }
}