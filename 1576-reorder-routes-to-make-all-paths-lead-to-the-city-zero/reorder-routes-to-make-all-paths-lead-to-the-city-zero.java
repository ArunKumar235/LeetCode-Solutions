class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Edge>> adj = new HashMap<>();

        for(int[] arr: connections){
            adj.computeIfAbsent(arr[0], k -> new ArrayList<Edge>()).add(new Edge(arr[1], 1));
            adj.computeIfAbsent(arr[1], k -> new ArrayList<Edge>()).add(new Edge(arr[0], 0));
        }
        return bfs(0, n, adj);
    }

    private int bfs(int node, int n, Map<Integer, List<Edge>> adj){
        int count = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;

        while(!q.isEmpty()){
            int curr = q.poll();
            if(!adj.containsKey(curr)){
                continue;
            }
            for(Edge e: adj.get(curr)){
                if(!visited[e.node]){
                    visited[e.node] = true;
                    q.offer(e.node);
                    count += e.weight;
                }
            }
        }

        return count;
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