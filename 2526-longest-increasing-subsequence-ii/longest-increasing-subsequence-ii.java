class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int max = 0;
        for(int num: nums) max = Math.max(max, num);

        SegmentTree st = new SegmentTree(max + 1);

        int ans = 1;
        for(int num: nums){
            int maxValueInRange = st.search(Math.max(0, num - k), num - 1) + 1;
            
            st.update(num, maxValueInRange);

            ans = Math.max(ans, maxValueInRange);
        }
        return ans;
    }
}

class SegmentTree{
    int n;
    static Node head;

    class Node{
        int val;

        int l;
        int r;

        Node left;
        Node right;

        public Node(int l, int r){
            this.l = l;
            this.r = r;
        }
    }

    public SegmentTree(int n){
        this.n = n;
        this.head = build(0, n);
    }

    private Node build(int l, int r){
        if(l == r) return new Node(l, r);
        Node node = new Node(l, r);

        int mid = l + (r-l)/2;

        node.left = build(l, mid);
        node.right = build(mid+1, r);

        return node;
    }

    public int search(int l, int r){
        return search(l, r, head);            
    }

    private int search(int l, int r, Node node){
        // out of range
        if(node == null || node.r < l || r < node.l) return Integer.MIN_VALUE;
        // complete overlap
        if(l <= node.l && node.r <= r) return node.val;
        // partial overlap
        return Math.max(search(l, r, node.left), search(l, r, node.right));
    }

    public void update(int idx, int val){
        update(idx, val, this.head);
    }

    private void update(int idx, int val, Node node){
        if(idx < node.l || node.r < idx) return;

        node.val = Math.max(val, node.val);

        // if not a leaf node
        if(node.l != node.r){
            update(idx, val, node.left);
            update(idx, val, node.right);
        }
    }
}