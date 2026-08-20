class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] t: times){
            int u = t[0]-1;
            int v = t[1]-1;
            int w = t[2];

            adj.get(u).add(new int[]{v, w});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dfs(k-1, 0, adj, dist);

        int max = 0;
        for(int d: dist){
            if(d == Integer.MAX_VALUE) return -1;
            max = Math.max(max, d);
        }
        return max;
    }

    private void dfs(int node, int time, List<List<int[]>> adj, int[] dist){
        if(time >= dist[node]) return;
        
        dist[node] = time;

        for(int[] nei: adj.get(node)){
            dfs(nei[0], time + nei[1], adj, dist);
        }
    }
}