class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int[] Q = queries.clone();
        Arrays.sort(Q);

        // interval size - right interval
        PriorityQueue<int[]> eligible = new PriorityQueue<>((a, b) ->{
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int i = 0;
        Map<Integer, Integer> res = new HashMap<>();

        for(int q: Q){
            while(i < intervals.length && intervals[i][0] <= q){
                int l = intervals[i][0];
                int r = intervals[i++][1];

                eligible.offer(new int[]{r-l +1, r});
            }

            while(!eligible.isEmpty() && eligible.peek()[1] < q){
                eligible.poll();
            }
            res.put(q, eligible.isEmpty() ? -1 : eligible.peek()[0]);
        }

        i = 0;
        int[] answer = new int[queries.length];
        for(int q: queries){
            answer[i++] = res.get(q);
        }
        return answer;
    }
}