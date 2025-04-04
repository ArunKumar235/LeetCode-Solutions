class Solution {

    int count = 0;

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Edge>> adj = new HashMap<>();

        for(int[] arr: connections){
            adj.computeIfAbsent(arr[0], k -> new ArrayList<Edge>()).add(new Edge(arr[1], 1));
            adj.computeIfAbsent(arr[1], k -> new ArrayList<Edge>()).add(new Edge(arr[0], 0));
        }
        dfs(0, -1, adj);

        return count;
    }

    private void dfs(int node, int parent, Map<Integer, List<Edge>> adj){
        if(!adj.containsKey(node)) return;

        for(Edge e: adj.get(node)){
            if(e.node != parent){
                count += e.weight;
                dfs(e.node, node, adj);
            }
        }
    }
}

class Edge{
    int node;
    int weight;

    Edge(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}