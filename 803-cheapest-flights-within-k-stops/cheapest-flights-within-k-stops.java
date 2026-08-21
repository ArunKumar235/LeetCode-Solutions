class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] flight: flights){
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];

            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(new int[]{v, price});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        // node - stops
        int[][] dp = new int[n][k+2];
        for(int[] row: dp) Arrays.fill(row, Integer.MAX_VALUE);

        // node - price - stops
        pq.offer(new int[]{src, 0, 0});
        dp[src][0] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            int price = curr[1];
            int stop = curr[2];

            if(u == dst) return price;

            if(stop > k) continue;

            if(price > dp[u][stop]) continue;

            if(!adj.containsKey(u)) continue;
            for(int[] nei: adj.get(u)){
                int v = nei[0];
                int newPrice = price + nei[1];
                int newStop = stop + 1;
                
                if(newPrice < dp[v][newStop]){
                    dp[v][newStop] = newPrice;
                    pq.offer(new int[]{v, newPrice, newStop});
                }
            }
        }
        return -1;
    }
}