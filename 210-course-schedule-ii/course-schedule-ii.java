class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i<numCourses; i++) adj.add(new ArrayList<>());

        for(int[] pre: prerequisites) adj.get(pre[0]).add(pre[1]);

        int[] state = new int[numCourses + 1];
        // 0 unvisited
        // 1 visiting
        // 2 visited
        int[] order = new int[numCourses];
        
        for(int i = 0; i<numCourses; i++){
            if(!dfs(i, adj, state, order)) return new int[]{};
        }
        
        return order;
    }

    private boolean dfs(int course, List<List<Integer>> adj, int[] state, int[] order){
        if(state[course] == 1) return false;

        if(state[course] == 2) return true;

        state[course] = 1;

        for(int next: adj.get(course)){
            if(!dfs(next, adj, state, order)) return false;
        }

        int idx = state[order.length]++;
        order[idx] = course;
        state[course] = 2;

        return true;
    }
}