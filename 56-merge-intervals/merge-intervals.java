class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));

        List<int[]> res = new ArrayList<>();
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
                res.add(new int[]{prevStart, prevEnd});
                prevStart = start;
                prevEnd = end;
            }
        }
        res.add(new int[]{prevStart, prevEnd});
        
        return res.toArray(int[][]::new);
    }
}