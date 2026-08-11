class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer, Set<Integer>> revAdj = new HashMap<>();

        for(int i = 0; i<numCourses; i++) revAdj.put(i, new HashSet<>());

        for(int[] pre: prerequisites) revAdj.get(pre[1]).add(pre[0]);

        boolean[] visited = new boolean[numCourses];

        for(int i = 0; i<numCourses; i++) dfs(revAdj, i, visited);

        List<Boolean> ans = new ArrayList<>();

        for(int[] q: queries) ans.add(revAdj.get(q[1]).contains(q[0]));

        return ans;
    }

    private void dfs(Map<Integer, Set<Integer>> revAdj, int course, boolean[] visited){
        if(visited[course]) return;

        visited[course] = true;

        Set<Integer> all = revAdj.get(course);
        List<Integer> parents = new ArrayList<>(all);

        for(int parent: parents){
            dfs(revAdj, parent, visited);
            all.addAll(revAdj.get(parent));
        }
    }
}