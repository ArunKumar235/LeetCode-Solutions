class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDeg = new int[numCourses];

        for(int i = 0; i<numCourses; i++) adj.add(new ArrayList<>());
        for(int[] pre: prerequisites){
            adj.get(pre[1]).add(pre[0]);
            inDeg[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<numCourses; i++) if(inDeg[i] == 0) q.offer(i);

        int[] res = new int[numCourses];
        int idx = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            res[idx++] = u;

            for(int v: adj.get(u)){
                inDeg[v]--;
                if(inDeg[v] == 0) q.offer(v);
            }
        }
        return idx == numCourses ? res : new int[]{};
    }
}

// [1, 0], [2, 1] 0 -> 1 -> 2