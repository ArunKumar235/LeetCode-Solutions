class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        int i = 0;
        
        // case 1 : no overlapping before merging
        while(i < n && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        
        // case 2 : overlapping and merging intervals
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);
        
        // case 3 : no overlapping after merging intervals
        while(i < n){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(int[][]::new);
    }
}