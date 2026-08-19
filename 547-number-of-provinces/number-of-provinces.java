class Solution {
    int[] parent;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        Arrays.fill(parent, -1);

        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(isConnected[i][j] == 1){
                    union(i, j);
                }
            }
        }
        int res = 0;
        for(int p: parent) if(p<0) res++;
        return res;
    }

    private void union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return;

        if(parent[pu] <= parent[pv]){
            parent[pu] += parent[pv];
            parent[pv] = pu;
        }else{
            parent[pv] += parent[pu];
            parent[pu] = pv;
        }
    }

    private int find(int u){
        if(parent[u] < 0) return u;

        parent[u] = find(parent[u]);
        return parent[u];
    }
}