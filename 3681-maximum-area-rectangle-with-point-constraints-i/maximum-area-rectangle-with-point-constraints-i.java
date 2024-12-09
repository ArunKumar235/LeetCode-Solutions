class Solution {
    public int maxRectangleArea(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] num : points){
            Set<Integer> set = map.getOrDefault(num[0], new HashSet<>());
            set.add(num[1]);
            map.put(num[0], set);
        }
        int res = 0;

        for(int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                if(x1 == x2 || y1 == y2) continue;
                if(map.get(x1).contains(y2) && map.get(x2).contains(y1)){
                    boolean innerPt = false;
                    int minX = Math.min(x1, x2), maxX = Math.max(x1, x2);
                    int minY = Math.min(y1, y2), maxY = Math.max(y1, y2);
                    for (int[] num : points) {
                        int px = num[0], py = num[1];
                        if((px == x1 && py == y1) || (px == x2 && py == y2) ||
                            (px == x1 && py == y2) || (px == x2 && py == y1)){
                            continue;
                        }
                        if(px > minX && px < maxX && py > minY && py < maxY){
                            innerPt = true;
                            break;
                        }
                        if((px == minX || px == maxX) && (py >= minY && py <= maxY)){
                            innerPt = true;
                            break;
                        }
                        if((py == minY || py == maxY) && (px >= minX && px <= maxX)){
                            innerPt = true;
                            break;
                        }
                    }
                    if (!innerPt) {
                        int area = Math.abs(x2 - x1) * Math.abs(y2 - y1);
                        res = Math.max(res, area);
                    }
                }
            }
        }

        return res > 0 ? res : -1;
    }
}
