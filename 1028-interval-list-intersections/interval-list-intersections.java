class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();

        int i = 0, n = firstList.length;
        int j = 0, m = secondList.length;
        
        while(i < n && j < m){
            int s1 = firstList[i][0];
            int s2 = secondList[j][0];

            int e1 = firstList[i][1];
            int e2 = secondList[j][1];
            
            int intersectStart = Math.max(s1, s2);
            int intersectEnd = Math.min(e1, e2);

            if(intersectStart <= intersectEnd){
                res.add(new int[]{intersectStart, intersectEnd});
            }

            if(e1 < e2) i++;
            else j++;
        }
        return res.toArray(int[][]::new);
    }
}