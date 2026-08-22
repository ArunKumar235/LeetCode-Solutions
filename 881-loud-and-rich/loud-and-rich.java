class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;

        // adj[i] -> list of people poorer than i
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] edge: richer){
            int rich = edge[0];
            int poor = edge[1];

            adj.get(rich).add(poor);
        }
        
        boolean[] visited = new boolean[n];
        // poor on bottom <<< rich on top
        Stack<Integer> stack = new Stack<>();

        for(int r = 0; r<n; r++){
            if(!visited[r]){
                dfs(r, visited, adj, stack);
            }
        }

        // bestPersonFor[i] = quietest person among i and everyone richer than i
        // Initially themselves is the quitest know person
        int[] bestPersonFor = new int[n];
        for (int i = 0; i < n; i++) bestPersonFor[i] = i;

        // Rich first >>> Poor last
        while(!stack.isEmpty()){
            int rich = stack.pop();

            for(int poor : adj.get(rich)){
                int bestRich = bestPersonFor[rich];
                int bestPoor = bestPersonFor[poor];

                if(quiet[bestRich] < quiet[bestPoor]){
                    bestPersonFor[poor] = bestPersonFor[rich];
                }
            }
        }
        return bestPersonFor;
    }

    private void dfs(int rich, boolean[] visited, List<List<Integer>> adj, Stack<Integer> stack){
        visited[rich] = true;

        for(int poor: adj.get(rich)){
            if(!visited[poor]){
                dfs(poor, visited, adj, stack);
            }
        }
        stack.push(rich);
    }
}