class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] t: times){
            int u = t[0]-1;
            int v = t[1]-1;
            int w = t[2];

            adj.get(u).add(new int[]{v, w});
        }

        int res = 0;

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        
        pq.offer(new int[]{k-1, 0});

        while(!pq.isEmpty()){
            int u = pq.peek()[0];
            int t = pq.poll()[1];

            if(visited.contains(u)) continue;

            visited.add(u);
            res = Math.max(res, t);

            for(int[] nei: adj.get(u)){
                int v = nei[0];
                int t1 = nei[1];
                if(!visited.contains(v)){
                    pq.offer(new int[]{v, t + t1});
                }
            }
        }
        return visited.size() == n ? res : -1;
    }
}