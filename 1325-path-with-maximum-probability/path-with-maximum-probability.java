// bellman-ford
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] dp = new double[n];
        Arrays.fill(dp, 0.0);
        dp[start_node] = 1.0;

        for(int i = 0; i < n-1; i++){
            boolean updated = false;

            for(int j = 0; j < edges.length; j++){
                int u = edges[j][0];
                int v = edges[j][1];
                double prob = succProb[j];

                // u -> v
                if(dp[u] * prob > dp[v]){
                    dp[v] = dp[u] * prob;
                    updated = true;
                }

                // v -> u
                if(dp[v] * prob > dp[u]){
                    dp[u] = dp[v] * prob;
                    updated = true;
                }
            }
            if(!updated){
                break;
            }
        }
        return dp[end_node];
    }
}