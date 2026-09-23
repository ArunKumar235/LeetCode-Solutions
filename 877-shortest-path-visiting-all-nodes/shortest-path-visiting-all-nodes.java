class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        
        boolean[][] visited = new boolean[n][1<<n];
        Queue<Node> q = new LinkedList<>();

        int visitedAll = (1<<n)-1;

        for(int i = 0; i < n; i++){
            int state = 1<<i;
            visited[i][state] = true;
            q.offer(new Node(i, state));
        }

        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node curr = q.poll();
                int node = curr.currNode;
                int state = curr.state;

                if(state == visitedAll) return steps;

                for(int nei: graph[node]){
                    int newState = state | (1<<nei);

                    if(visited[nei][newState]) continue;

                    q.offer(new Node(nei, newState));
                    visited[nei][newState] = true;
                }
            }
            steps++;
        }
        return -1;
    }
}

class Node{
    int currNode;
    int state;

    Node(int currNode, int state){
        this.currNode = currNode;
        this.state = state;
    }
}