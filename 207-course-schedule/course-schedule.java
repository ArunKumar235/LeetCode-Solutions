class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i<numCourses; i++) adj.add(new ArrayList<>());

        for(int[] pre: prerequisites) adj.get(pre[0]).add(pre[1]);

        int[] state = new int[numCourses];
        // 0 = unvisited
        // 1 = visiting
        // 2 = visited

        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, adj, state)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, List<List<Integer>> adj, int[] state){
        if(state[course] == 1) return false; // cycle found
    
        if(state[course] == 2) return true; // already visited
    
        state[course] = 1;

        for(int next : adj.get(course)){
            if(!dfs(next, adj, state)){
                return false;
            }
        }
        state[course] = 2;

        return true;
    }
}