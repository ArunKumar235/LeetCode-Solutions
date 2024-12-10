class Solution {
    public int maxRectangleArea(int[][] points) {
        int res = -1;
        int n = points.length;
        
        Set<String> set = new HashSet<>();
        for(int[] pt: points){
            set.add(pt[0]+"_"+pt[1]);
        }

        for(int i = 0; i<n; i++) {
            for(int j = i+1; j<n; j++){
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                if(x1==x2 || y1==y2) continue;
                if(!(set.contains(x1+"_"+y2) && set.contains(x2+"_"+y1))) continue;

                boolean innerpt = false;

                int minX = Math.min(x1, x2), minY = Math.min(y1, y2);
                int maxX = Math.max(x1, x2), maxY = Math.max(y1, y2);

                for(int pt[]: points){
                    int px = pt[0];
                    int py = pt[1];

                    // corners
                    if((px==x1 && py==y1) || (px==x2 && py == y2) || (px==x1 && py == y2) || (px==x2 && py == y1))
                        continue;
                    
                    // inner pt's
                    if(px>minX && px<maxX && py>minY && py<maxY){
                        innerpt = true;
                        break;
                    }

                    // vertical edges
                    if((px == minX || px == maxX) && (py>=minY && py<=maxY)){
                        innerpt = true;
                        break;
                    }

                    // horizontal edge
                    if((py == minY || py == maxY) && (px >= minX && px <= maxX)){
                        innerpt = true;
                        break;
                    }

                }
                if(!innerpt){
                    int area = Math.abs(x1-x2) * Math.abs(y1-y2);
                    res = Math.max(res, area);
                }

            }
        }
        return res;
    }
}