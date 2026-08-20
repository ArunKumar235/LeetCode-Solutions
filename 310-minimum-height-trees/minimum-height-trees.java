class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Arrays.asList(0);

        List<List<Integer>> adj = new ArrayList<>();
        int[] edgeCount = new int[n];

        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);

            edgeCount[e[0]]++;
            edgeCount[e[1]]++;
        }

        Queue<Integer> leaves = new ArrayDeque<>();
        for(int i = 0; i<n; i++){
            if(edgeCount[i] == 1) leaves.offer(i);
        }

        int remainingNodes = n;

        while(remainingNodes > 2){
            int size = leaves.size();

            for(int i = 0; i<size; i++){
                int leaf = leaves.poll();
                edgeCount[leaf]--;
                remainingNodes--;
                
                for(int nei: adj.get(leaf)){
                    edgeCount[nei]--;

                    if(edgeCount[nei] == 1){
                        leaves.add(nei);
                    }
                }
            }
        }
        return new ArrayList<>(leaves);
    }
}