class Solution {
    public long minInversionCount(int[] nums, int k) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        HashMap<Integer, Integer> rank = new HashMap<>();
        int idx = 0;

        for (int val : sorted){
            if(!rank.containsKey(val)){
                rank.put(val, idx++);
            }
        }

        SegmentTree st = new SegmentTree(idx);

        long inversions = 0;

        for(int i = 0; i < k; i++){
            int r = rank.get(nums[i]);

            long greater = st.query(r+1, idx-1);

            inversions += greater;
            st.add(r, 1);
        }

        long answer = inversions;

        for(int right = k; right < n; right++){
            int left = right - k;

            int removedRank = rank.get(nums[left]);
            inversions -= st.query(0, removedRank - 1);
            st.add(removedRank, -1);

            int addedRank = rank.get(nums[right]);
            long greater = st.query(addedRank+1, idx-1);

            inversions += greater;
            st.add(addedRank, 1);

            answer = Math.min(answer, inversions);
        }

        return answer;
    }

    static class SegmentTree {
        private final int[] tree;
        private final int n;

        SegmentTree(int n){
            this.n = n;
            this.tree = new int[4*n];
        }

        public void add(int idx, int delta){
            add(1, 0, n-1, idx, delta);
        }

        private void add(int node, int s, int e, int idx, int delta){
            if(s==e){
                tree[node] += delta;
                return;
            }
            int mid = s + (e-s)/2;

            if(idx<=mid){
                add(2*node, s, mid, idx, delta);
            }else{
                add(2*node +1, mid+1, e, idx, delta);
            }
            tree[node] = tree[2*node] + tree[2*node +1];
        }

        public int query(int qs, int qe){
            if(qs > qe) return 0;

            return query(1, 0, n-1, qs, qe);
        }

        private int query(int node, int s, int e, int qs, int qe){
            if(qe < s || e < qs) return 0;

            if(qs <= s && e <= qe) return tree[node];

            int mid = s +(e-s)/2;

            return query(2*node, s, mid, qs, qe) + query(2*node +1, mid+1, e, qs, qe);
        }
    }
}