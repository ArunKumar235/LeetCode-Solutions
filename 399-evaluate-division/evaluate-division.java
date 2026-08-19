class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> adj = new HashMap<>();

        for(int i = 0; i<equations.size(); i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);

            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());

            adj.get(u).add(new Pair(v, values[i]));
            adj.get(v).add(new Pair(u, 1.0/values[i]));
        }
        
        double[] res = new double[queries.size()];

        for(int i = 0; i<queries.size(); i++){
            String src = queries.get(i).get(0);
            String trgt = queries.get(i).get(1);

            res[i] = dfs(src, trgt, adj, new HashSet<>());
        }
        return res;
    }

    private double dfs(String src, String trgt, Map<String, List<Pair>> adj, Set<String> visited){
        if(!adj.containsKey(src) || !adj.containsKey(trgt)) return -1.0;

        if(src.equals(trgt)) return 1.0;

        visited.add(src);

        for(Pair nei: adj.get(src)){
            if(!visited.contains(nei.node)){
                double res = dfs(nei.node, trgt, adj, visited);
                if(res != -1){
                    return nei.weight * res;
                }
            }
        }
        return -1.0;
    }
    
    static class Pair{
        String node;
        double weight;
        Pair(String node, double weight){
            this.node = node;
            this.weight = weight;
        }
    }
}