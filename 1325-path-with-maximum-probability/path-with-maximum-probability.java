// dijkistra
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());

        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];

            adj.get(u).add(new double[]{v, prob});
            adj.get(v).add(new double[]{u, prob});
        }

        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));

        pq.offer(new double[]{start_node, 1.0});

        while(!pq.isEmpty()){
            double[] curr = pq.poll();
            int node = (int) curr[0];
            double prob = curr[1];

            if(prob < maxProb[node]) continue;

            if(node == end_node) return prob;

            for(double[] edge : adj.get(node)){
                int next = (int) edge[0];
                double newProb = prob * edge[1];

                if (newProb > maxProb[next]) {
                    maxProb[next] = newProb;
                    pq.offer(new double[]{next, newProb});
                }
            }
        }
        return 0.0;
    }
}