class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj.get(u).add(new int[]{v, w});

            adj.get(v).add(new int[]{u, 2 * w});
        }

        int INF = Integer.MAX_VALUE;

        int[] dist = new int[n];
        Arrays.fill(dist, INF);

        // cost - node
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        dist[0] = 0;
        pq.offer(new int[]{0, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            int cost = curr[0];
            int node = curr[1];

            if(cost > dist[node]) continue;

            if(node == n - 1) return cost;

            for(int[] nei : adj.get(node)){
                int next = nei[0];
                int newCost = cost + nei[1];

                if(newCost < dist[next]){
                    dist[next] = newCost;
                    pq.offer(new int[]{newCost, next});
                }
            }
        }
        return -1;
    }
}
// switch could be used once per edge, not once globally

// No need to track switch usage since an optimal path with positive weights never revisits a node, so each node's switch can be used at most once.