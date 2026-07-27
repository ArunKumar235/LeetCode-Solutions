class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries){
        int n = nums.length;
        int[] peak = new int[n];

        for(int i = 1; i < n - 1; i++){
            if(nums[i - 1] < nums[i] && nums[i] > nums[i + 1]){
                peak[i] = 1;
            }
        }
        SegmentTree st = new SegmentTree(n);
        for(int i = 0; i < n; i++){
            st.update(i, peak[i]);
        }
        List<Integer> ans = new ArrayList<>();

        for(int[] query : queries){
            if(query[0] == 1){
                int l = query[1];
                int r = query[2];

                int s = Math.max(1, l + 1);
                int e = Math.min(n - 2, r - 1);

                if(s > e){
                    ans.add(0);
                }else{
                    ans.add(st.query(s, e));
                }
            }else{
                int idx = query[1];
                nums[idx] = query[2];

                for(int i = idx - 1; i <= idx + 1; i++){
                    if(0 < i && i < n - 1){
                        int val = (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) ? 1 : 0;
                        if(peak[i] != val){
                            peak[i] = val;
                            st.update(i, val);
                        }
                    }
                }
            }
        }
        return ans;
    }

    class SegmentTree{

        class Node{
            int start, end, val;
            Node left, right;

            Node(int start, int end){
                this.start = start;
                this.end = end;
                this.val = 0;
            }
        }

        Node root;

        SegmentTree(int n){
            root = build(0, n - 1);
        }

        private Node build(int l, int r){
            if(l > r)return null;
            Node node = new Node(l, r);
            if(l == r)return node;
            int mid = l + (r - l) / 2;
            node.left = build(l, mid);
            node.right = build(mid + 1, r);
            return node;
        }

        public void update(int idx, int val){
            update(root, idx, val);
        }

        private int update(Node node, int idx, int val){
            if(node == null) return 0;
            if(idx < node.start || node.end < idx) return node.val;

            if(node.start == idx && node.end == idx){
                node.val = val;
                return val;
            }
            node.val = update(node.left, idx, val) + update(node.right, idx, val);
            return node.val;
        }

        public int query(int l, int r){
            return query(root, l, r);
        }

        private int query(Node node, int l, int r){
            if(node == null || r < node.start || node.end < l){
                return 0;
            }
            if(l <= node.start && node.end <= r){
                return node.val;
            }
            return query(node.left, l, r) + query(node.right, l, r);
        }
    }
}