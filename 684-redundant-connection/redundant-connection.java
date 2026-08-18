class Solution {
    List<List<Integer>> adj;
    Set<Integer> cycle;
    boolean[] visited;
    int cycleStart = -1;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        adj = new ArrayList<>();
        
        for(int i = 0; i<=n; i++) adj.add(new ArrayList<>());

        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        cycle = new HashSet<>();
        visited = new boolean[n+1];

        dfs(1, -1);

        for(int i = n-1; i>=0; i--){
            if(cycle.contains(edges[i][0]) && cycle.contains(edges[i][1])) 
                return new int[]{edges[i][0], edges[i][1]};
        }
        return new int[]{};
    }

    private void dfs(int node, int par){
        if(visited[node]){
            cycleStart = node;
            return;
        }

        visited[node] = true;
        for(int nei: adj.get(node)){
            if(nei==par) continue;
            
            if(cycle.isEmpty()) dfs(nei, node);
            if(cycleStart != -1) cycle.add(node);
            if(node==cycleStart){ 
                cycleStart = -1;
                return;
            }
        }
        return;
    }
}