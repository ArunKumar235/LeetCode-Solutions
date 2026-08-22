class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> revAdj = new ArrayList<>();
        for(int i = 0; i<n; i++) revAdj.add(new ArrayList<>());

        int[] outdeg = new int[n];
        for(int u = 0; u<n; u++){
            for(int v: graph[u]){
                revAdj.get(v).add(u);
                outdeg[u]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++) if(outdeg[i] == 0) q.offer(i);

        List<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){
            int v = q.poll();
            res.add(v);

            for(int u: revAdj.get(v)){
                outdeg[u]--;
                if(outdeg[u] == 0){
                    q.offer(u);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}