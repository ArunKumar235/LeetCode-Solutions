/*
We need to calculate the total union area of all rectangles, 
avoiding double-counting overlapping regions.

Instead of calculating rectangle areas directly, 
use Coordinate Compression to divide the plane into smaller, non-overlapping cells.
(sum areas cell by cell, skip overlapping duplicate cells)

Mark each cell as visited when it is covered by a rectangle. Count its area only once.
*/
class Solution {
    long MOD = (long) 1e9 + 7;
    public int rectangleArea(int[][] rectangles) {
        TreeSet<Integer> x = new TreeSet<>();
        TreeSet<Integer> y = new TreeSet<>();
        
        // store all unique x and y coordinates in sorted sequence
        for(int[] rect: rectangles){
            int x1 = rect[0];
            int y1 = rect[1];
            int x2 = rect[2];
            int y2 = rect[3];

            x.add(x1);
            x.add(x2);
            y.add(y1);
            y.add(y2);
        }

        // coordinate compress to reduce 10^9 range to atmost 2N unique coordinates across each axis
        
        // Coordinate value -> Compressed index
        Map<Integer, Integer> xCoord = new HashMap<>();
        Map<Integer, Integer> yCoord = new HashMap<>();

        // Compressed index -> Actual coordinate value
        int[] xVal = new int[x.size()];
        int[] yVal = new int[y.size()];
        
        int idx = 0;
        for(int coord: x){
            xCoord.put(coord, idx);
            xVal[idx] = coord;
            idx++;
        }
        
        idx = 0;
        for(int coord: y){
            yCoord.put(coord, idx);
            yVal[idx] = coord;
            idx++; 
        }

        boolean[][] vis = new boolean[x.size()][y.size()];

        long area = 0;
        for(int[] rect: rectangles){
            int startX = rect[0];
            int endX = rect[2];
            
            int startY = rect[1];
            int endY = rect[3];
            
            for(int i = xCoord.get(startX); i < xCoord.get(endX); i++){
                
                for(int j = yCoord.get(startY); j < yCoord.get(endY); j++){
                    if(vis[i][j]) continue; // cell area already added;

                    long w = (long) xVal[i+1] - xVal[i];
                    long h = (long) yVal[j+1] - yVal[j];

                    area += (h * w) % MOD;
                    area %= MOD;

                    vis[i][j] = true;
                }
            }
        }
        return (int) area;
    }
}