class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            int res1 = Integer.compare(a[0],b[0]);
            if(res1!=0) return res1;
            return Integer.compare(a[1],b[1]);
        });

        List<List<Integer>> res = new ArrayList<>();
        int prevStart = Integer.MIN_VALUE;
        int prevEnd = Integer.MIN_VALUE;
        for(int[] interval: intervals){
            int start = interval[0];
            int end = interval[1];
            if(prevStart == Integer.MIN_VALUE) { 
                prevStart = start;
                prevEnd = end;
                continue;
            }
            if(prevEnd>=start){
                prevEnd = Math.max(end, prevEnd);
            }else{
                res.add(Arrays.asList(prevStart, prevEnd));
                prevStart = start;
                prevEnd = end;
            }
        }
        res.add(Arrays.asList(prevStart, prevEnd));
        return res.stream()
            .map(row -> row.stream()
                .mapToInt(Integer::intValue).toArray())
            .toArray(int[][]::new);
    }
}