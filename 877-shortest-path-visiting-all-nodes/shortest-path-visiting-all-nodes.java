class Solution {
    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        boolean[][] visited = new boolean[n][1<<n];
        Queue<Node> q = new LinkedList<>(); // store current level
        int req = (1<<n) -1; // all nodes visited

        // initialize all the current nodes
        for(int i = 0; i<n; i++){
            int newTravel = 1<<i;
            visited[i][newTravel] = true;
            q.add(new Node(i, newTravel));
        }
        // track steps
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                Node curr = q.poll();
                int val = curr.val;
                int travel = curr.travel;

                if(travel==req){ // check if all nodes are visited
                    return res;
                }

                for(int newNode: graph[val]){
                    int newTravel = travel | (1<<newNode);
                    if(!visited[newNode][newTravel]){ // check if a path is already visited
                        q.add(new Node(newNode, newTravel));
                        visited[newNode][newTravel] = true;
                    }
                }
            }
            res++;
        }
        return res;
    }
}


class Node{
    int val;
    int travel;
    Node(int val, int travel){
        this.val = val;
        this.travel = travel;
    }
}