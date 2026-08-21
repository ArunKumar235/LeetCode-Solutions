class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
        
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);

        for(int[] edge: times){
            int u = edge[0]-1;
            int v = edge[1]-1;
            int time = edge[2];

            adj.get(u).add(new int[]{v, time});
        }

        // node - time
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{k-1, 0});
        dist[k-1] = 0;

        // Shortest Path Faster Algorithm (SPFA)
        // optimised bellman-ford algorithm
        // instead of relaxing all nodes, relax only updated nodes
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int u = curr[0];
            int time = curr[1];

            if(dist[u] < time) continue;

            for(int[] nei: adj.get(u)){
                int v = nei[0];
                int newTime = time + nei[1];

                if(newTime < dist[v]){
                    dist[v] = newTime;
                    q.offer(new int[]{v, newTime});
                }
            }
        }
        int max = 0;
        for(int t: dist) max = Math.max(max, t);
        
        return max == (int) 1e9 ? -1 : max;
    }
}