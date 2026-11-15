class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        List<int[]> pairs = new ArrayList<>();

        for(int i = 0; i < n; i++){
            pairs.add(new int[]{nums1[i], nums2[i]});
        }

        Collections.sort(pairs, (a, b) -> Integer.compare(b[1], a[1]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long total = 0;
        long res = 0;

        for(int i = 0; i < n; i++){
            total += pairs.get(i)[0];
            minHeap.offer(pairs.get(i)[0]);

            if(minHeap.size() > k) total -= minHeap.poll();
            if(minHeap.size() == k) res = Math.max(res, total * pairs.get(i)[1]);
            // since nums2 is decreasing in order, multiplying by it, even when
            // cooresponding nums1 is removed wont change res (max value)
        }
        return res;
    }
}
// 2 3 1 3
// 4 3 2 1 -> sort desc by num2