class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;

        int dst = n-1;

        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int[] e: edges){
            int u = e[0];
            int v = e[1];
            int time = e[2];

            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());

            adj.get(u).add(new int[]{v, time});
            adj.get(v).add(new int[]{u, time});
        }

        // node - time - cost
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[]{0, 0, passingFees[0]});

        // node - time
        int[][] dp = new int[n][maxTime+1];
        for(int[] row: dp) Arrays.fill(row, Integer.MAX_VALUE);

        dp[0][0] = passingFees[0];

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            int time = curr[1];
            int cost = curr[2];

            if(u == dst) return cost;

            if(cost > dp[u][time]) continue;

            if(!adj.containsKey(u)) continue;

            for(int[] nei: adj.get(u)){
                int v = nei[0];
                int newTime = time + nei[1];
                int newCost = cost + passingFees[v];
                
                if(newTime > maxTime) continue;
                if(newCost < dp[v][newTime]){
                    dp[v][newTime] = newCost;
                    pq.offer(new int[]{v, newTime, newCost});
                }
            }
        }
        return -1;
    }
}