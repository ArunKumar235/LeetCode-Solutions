class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n];
        Arrays.fill(parent, -1);

        for(int[] e: edges){
            if(union(e[0]-1, e[1]-1)){
                return e;
            }
        }

        return new int[]{};
    }

    private boolean union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return true;

        if(pu <= pv){
            parent[pu] += parent[pv];
            parent[pv] = pu;
            // parent[v] = pu;
        }else{
            parent[pv] += parent[pu];
            parent[pu] = pv;
            // parent[u] = pv;
        }
        return false;
    }

    private int find(int u){
        while(parent[u] >= 0){
            u = parent[u];
        }
        return u;
    }
}