class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length+1<n) return -1;
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] arr: connections){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0; i<n; i++){
            if(visited[i]==false){
                dfs(i, visited, adj);
                count++;
            }
        }
        return count-1;
    }

    private void dfs(int root, boolean[] visited, List<List<Integer>> adj){
        visited[root] = true;
        for(int node: adj.get(root)){
            if(!visited[node]) dfs(node, visited, adj);
        }
    }
}