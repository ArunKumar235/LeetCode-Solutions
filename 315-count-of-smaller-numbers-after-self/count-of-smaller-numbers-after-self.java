class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for(int num: sorted){
            if(!map.containsKey(num)){
                map.put(num, idx++);
            }
        }
        SegmentTree st = new SegmentTree(0, idx-1);
        List<Integer> res = new ArrayList<>();

        for(int i = nums.length-1; i>=0; i--){
            int rank = map.get(nums[i]);
            st.add(rank);
            int cnt = st.query(0, rank-1);
            res.add(cnt);
        }
        return res.reversed();
    }
}

class SegmentTree{
    static class Node{
        int start;
        int end;

        int freqSum;
        
        Node left;
        Node right;;

        public Node(int s, int e){
            start = s;
            end = e;
            freqSum = 0;
        }
    }
    Node root;
    
    public SegmentTree(int s, int e){
        root = constructTree(s, e);
    }

    private Node constructTree(int s, int e){
        if(s==e) return new Node(s, e);
        Node node = new Node(s, e);
        int mid = s + (e-s)/2;
        node.left = constructTree(s, mid);
        node.right = constructTree(mid+1, e);
        return node;
    }

    public void add(int val){
        update(root, val);
    }

    private int update(Node node, int val){
        if(node==null) return 0;
        if(val < node.start || node.end < val) return node.freqSum;

        if(node.start == val && node.end == val){
            return ++node.freqSum;
        }
        node.freqSum = update(node.left, val) + update(node.right, val);
        return node.freqSum;
    }

    public int query(int s, int e){
        if(s > e) return 0;
        return query(root, s, e);
    }

    private int query(Node node, int s, int e){
        if(node == null || e < node.start || node.end < s){
            return 0;
        }
        if(s <= node.start && node.end <= e){
            return node.freqSum;
        }
        return query(node.left, s, e) + query(node.right, s, e);
    }
}