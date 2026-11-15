class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();

        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];

        for(int[] interval: intervals){
            int start = interval[0];
            int end = interval[1];

            if(prevEnd < start){
                res.add(new int[]{prevStart, prevEnd});
                prevStart = start;
                prevEnd = end;
            }else{
                prevEnd = Math.max(prevEnd, end);
            }
        }
        res.add(new int[]{prevStart, prevEnd});

        return res.toArray(int[][]::new);
    }
}