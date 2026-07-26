class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        List<Integer> res = new ArrayList<>();

        SegmentTree st = new SegmentTree(min, max);
        
        for(int i = nums.length-1; i>=0; i--){
            st.add(nums[i]);
            int cnt = st.querySum(min, nums[i]-1);
            res.add(cnt);
        }
        return res.reversed();
    }
}

class SegmentTree{
    static class Node{
        public int start;
        public int end;

        public int freqSum;
        Node left;
        Node right;

        Node(int start, int end){
            this.start = start;
            this.end = end;
            freqSum = 0;
        }
    }

    private final Node root;

    public SegmentTree(int s, int e){
        root = constructTree(s, e);
    }

    private Node constructTree(int s, int e){
        if(s>e) return null;
        if(s==e){
            return new Node(s, e);
        }
        Node curr = new Node(s, e);
        int mid = s+ (e-s)/2;
        curr.left = constructTree(s, mid);
        curr.right = constructTree(mid+1, e);
        // curr.freqSum = curr.left.freqSum + curr.right.freqSum;
        return curr;
    }

    public int add(int val){
        return update(root, val);
    }

    private int update(Node node, int val){
        if(node==null) return 0;
        if(val < node.start || val > node.end){
            return node.freqSum;
        }
        if(node.start == node.end){
            return ++node.freqSum;
        }
        node.freqSum = update(node.left, val) + update(node.right, val);
        return node.freqSum;
    }

    public int querySum(int s, int e){
        if(s > e){
            return 0;
        }
        return query(root, s, e);
    }

    private int query(Node node, int s, int e){
        if(node == null || node.start > e || node.end < s){
            return 0;
        }
        if(s <= node.start && node.end <= e){
            return node.freqSum;
        }
        return query(node.left, s, e) + query(node.right, s, e);
    }
}