class Solution {
    SegmentTree st;
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        this.st = new SegmentTree(n-1);

        for(int i = 0; i < n; i++){
            st.update(i, chargeTimes[i]);
        }

        long[] prefix = new long[n+1];
        for(int i = 1; i <= n; i++) prefix[i] = prefix[i-1] + runningCosts[i-1];
        
        int l = 1;
        int r = n;
        int ans = 0;
        while(l <= r){
            int mid = l + (r-l)/2;

            if(check(mid, n, prefix, runningCosts, budget)){
                ans = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int k, int n, long[] prefix, int[] runningCosts, long budget){
        for(int i = 0; i+k <= n; i++){
            long total = prefix[i+k] - prefix[i];
            total *= k;
            total += st.query(i, i+k-1);

            if(total <= budget) return true;
        }
        return false;
    }
}

class SegmentTree{
    static class Node{
        Node(int l, int r){
            this.val = -1;
            this.l = l;
            this.r = r;
        }

        int val;
        int l;
        int r;
        Node left;
        Node right;
    }

    Node head;

    SegmentTree(int n){
        this.head = build(0, n);
    }

    public Node build(int l, int r){
        if(l == r) return new Node(l, r);
        Node node = new Node(l, r);
        int mid = l + (r-l)/2;
        node.left = build(l, mid);
        node.right = build(mid+1, r);
        return node;
    }

    public void update(int idx, int val){
        update(head, idx, val);
    }

    private int update(Node node, int idx, int val){
        if(idx < node.l || node.r < idx) return node.val;
        if(node.l == idx && idx == node.r){
            node.val = val;
            return node.val;
        }
        return node.val = Math.max(update(node.left, idx, val), update(node.right, idx, val));
    }

    public int query(int l, int r){
        return query(head, l, r);
    }

    private int query(Node node, int l, int r){
        if(node.r < l || r < node.l) return -1;
        if(l <= node.l && node.r <= r) return node.val;

        return Math.max(query(node.left, l, r), query(node.right, l, r));
    }
}