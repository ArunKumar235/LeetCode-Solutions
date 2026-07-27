class Solution {
    public List<Boolean> getResults(int[][] queries) {
        int maxX = 0;

        for(int[] query : queries){
            maxX = Math.max(maxX, query[1]);
        }

        SegmentTree st = new SegmentTree(maxX);
        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);

        List<Boolean> ans = new ArrayList<>();

        for(int[] query : queries){
            int type = query[0];
            int x = query[1];

            if(type == 1){
                if(obstacles.contains(x)){
                    continue;
                }

                Integer left = obstacles.lower(x);
                Integer right = obstacles.higher(x);

                st.update(x, x - left);

                if(right != null){
                    st.update(right, right - x);
                }

                obstacles.add(x);
            }else{
                int size = query[2];

                int left = obstacles.floor(x);
                int completeGap = st.query(0, left);
                int partialGap = x - left;

                ans.add(Math.max(completeGap, partialGap) >= size);
            }
        }
        return ans;
    }
}

class SegmentTree{
    static class Node{
        int start;
        int end;
        int max;

        Node left;
        Node right;

        Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    private final Node root;

    SegmentTree(int n){
        root = build(0, n);
    }

    private Node build(int start, int end){
        Node node = new Node(start, end);
        if(start == end){
            return node;
        }
        int mid = start + (end - start) / 2;
        node.left = build(start, mid);
        node.right = build(mid + 1, end);
        return node;
    }

    public void update(int index, int value){
        update(root, index, value);
    }

    private int update(Node node, int index, int value){
        if(node==null) return 0;
        if(index < node.start || node.end < index) return node.max;
        if(node.start == index && node.end == index){
            node.max = value;
            return node.max;
        }
        int left = update(node.left, index, value);
        int right = update(node.right, index, value);
        
        node.max = Math.max(left, right);
        return node.max;
    }

    public int query(int left, int right){
        if(left > right){
            return 0;
        }

        return query(root, left, right);
    }

    private int query(Node node, int left, int right){
        if(right < node.start || node.end < left){
            return 0;
        }
        if(left <= node.start && node.end <= right){
            return node.max;
        }
        return Math.max(
            query(node.left, left, right),
            query(node.right, left, right)
        );
    }
}