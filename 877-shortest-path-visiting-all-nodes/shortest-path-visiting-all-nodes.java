class Solution {
    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int req = (1 << n) - 1; // All nodes visited
        Set<String> set = new HashSet<>();
        Queue<Node> q = new LinkedList<>();

        // Initialize queue and visited set with all nodes
        for (int i = 0; i < n; i++) {
            int startTravel = 1 << i;
            set.add(i + "_" + startTravel);
            q.add(new Node(i, startTravel));
        }

        int res = 0; // Tracks the number of steps
        while (!q.isEmpty()) {
            int size = q.size();

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                int val = node.val;
                int travel = node.travel;

                // If all nodes are visited, return result
                if (travel == req) {
                    return res;
                }

                // Explore neighbors
                for (int newNode : graph[val]) {
                    int newTravel = travel | (1 << newNode);
                    String state = newNode + "_" + newTravel;

                    if (!set.contains(state)) {
                        q.add(new Node(newNode, newTravel));
                        set.add(state);
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