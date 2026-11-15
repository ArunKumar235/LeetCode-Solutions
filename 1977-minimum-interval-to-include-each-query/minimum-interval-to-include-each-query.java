// We don't need to explicitly remove every expired interval.

// The heap is sorted by interval length, not ending time.
// An expired interval might remain somewhere inside the heap. 
// That's okay because it cannot affect the answer unless it reaches the top.
class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // sort intervals by left asc
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] qs = new int[queries.length][2];
        for(int i = 0; i < queries.length; i++){
            qs[i][0] = queries[i];
            qs[i][1] = i;
        }
        // sort queries asc
        Arrays.sort(qs, (a, b) -> Integer.compare(a[0], b[0]));

        // [intervalLen, right] fetch smallest intervalLen in O(1)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        int[] res = new int[queries.length];
        int idx = 0;
        
        for(int[] query: qs){
            int q = query[0];
            int orgIdx = query[1];

            while(idx < intervals.length && intervals[idx][0] <= q){
                int l = intervals[idx][0];
                int r = intervals[idx][1];

                minHeap.offer(new int[]{r - l + 1, r});
                idx++;
            }

            // skip ineligible intervals
            while(!minHeap.isEmpty() && minHeap.peek()[1] < q){
                minHeap.poll();
            }
            res[orgIdx] = minHeap.isEmpty() ? -1 : minHeap.peek()[0];
        }
        return res;
    }
}