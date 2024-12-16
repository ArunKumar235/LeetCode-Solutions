class Solution {
    public int findCircleNum(int[][] isc) {
        int v = isc.length;
        boolean[] visited = new boolean[v];
        int res = 0;
        for(int i = 0; i<v; i++){
            if(!visited[i]){
                res++;
                dfs(isc, visited, i, v);
            }
        }
        return res;
    }

    public void dfs(int[][] isc, boolean[] visited, int currNode, int v){
        if(visited[currNode]) return;
        visited[currNode] = true;
        for(int i = 0 ; i<v; i++){
            if(isc[currNode][i]==1){
                dfs(isc, visited, i, v);
            }
        }
    }
}