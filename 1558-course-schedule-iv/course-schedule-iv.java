class Solution {
    public List<Boolean> checkIfPrerequisite(
        int numCourses, 
        int[][] prerequisites, 
        int[][] queries
    ){
        Map<Integer, Set<Integer>> revAdj = new HashMap<>();

        Map<Integer, Set<Integer>> preReq = new HashMap<>();

        for(int i = 0; i<numCourses; i++) revAdj.put(i, new HashSet<>());

        for(int[] pre: prerequisites) revAdj.get(pre[1]).add(pre[0]);

        for(int i = 0; i<numCourses; i++) dfs(i, revAdj, preReq);

        List<Boolean> res = new ArrayList<>();
        
        for(int[] q: queries){
            res.add(preReq.get(q[1]).contains(q[0]));
        }
        return res;
    }

    private Set<Integer> dfs(
        int course, 
        Map<Integer, Set<Integer>> revAdj, 
        Map<Integer, Set<Integer>> preReq
    ){
        if(preReq.containsKey(course)) return preReq.get(course);

        Set<Integer> reqs = new HashSet<>();

        for(int pre: revAdj.get(course)){
            reqs.addAll(dfs(pre, revAdj, preReq));
        }
        
        reqs.add(course);
        preReq.put(course, reqs);
        return reqs;
    }
}