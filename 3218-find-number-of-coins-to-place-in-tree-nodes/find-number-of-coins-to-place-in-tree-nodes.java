class Solution {
    int n;
    List<List<Integer>> adj;
    int[] cost;
    List<Integer>[] dp;

    public long[] placedCoins(int[][] edges, int[] cost) {
        this.n = edges.length+1;
        this.cost = cost;
        
        this.adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] e: edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u); 
            // we are given with undirected edges, 
            // we dont know which node is parent and child in an edge
        }

        this.dp = new ArrayList[n];

        dfs(0, -1);

        long[] res = new long[n];
        for(int i = 0; i < n; i++){
            List<Integer> vals = dp[i];
            
            if(vals == null || vals.size() < 3){
                res[i] = 1;
                continue;
            }

            int size = vals.size();
            long p1 = 1L * vals.get(size-3) * vals.get(size-2) * vals.get(size-1);
            long p2 = 1L * vals.get(0) * vals.get(1) * vals.get(size-1);

            res[i] = Math.max(0L, Math.max(p1, p2));
        }
        return res;
    }

    private List<Integer> dfs(int node, int parent){
        // Stores smallest 2 negative values (largest at root)
        PriorityQueue<Integer> negMaxHeap = new PriorityQueue<>(
            Collections.reverseOrder()
        );
        // Stores largest 3 non-negative values (smallest at root)
        PriorityQueue<Integer> posMinHeap = new PriorityQueue<>();
        
        if(cost[node] < 0) negMaxHeap.offer(cost[node]);
        else posMinHeap.offer(cost[node]);

        for(int child: adj.get(node)){
            if(child == parent) continue;

            List<Integer> childCosts = dfs(child, node);
            
            for(int val: childCosts){
                if(val < 0) negMaxHeap.offer(val);
                else posMinHeap.offer(val);
            }

            while(negMaxHeap.size() > 3) negMaxHeap.poll();
            while(posMinHeap.size() > 3) posMinHeap.poll();
        }
        
        List<Integer> res = new ArrayList<>();
        
        res.addAll(negMaxHeap);
        res.addAll(posMinHeap);

        Collections.sort(res);
        return dp[node] = res;
    }
}

// -6 -7  -> store top two neg, 
// (2 is enough to find res, but to track subtree size < 3 or not, we use 3)

// 1 2 3 -> store top three pos

// -7 -6 3