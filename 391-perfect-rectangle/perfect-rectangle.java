// condition 1 (area equality): Sum of individual areas = Bounding rectangle area
// necessary, but not sufficient because overlaps can cancel gaps.

// condition 2 (corner collision): The four corners of the bounding rectangle must appear exactly once.
// Every other corner must appear either 2 or 4 times.
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        long area = 0;

        Set<String> corners = new HashSet<>();

        for(int[] rect: rectangles){
            int x = rect[0];
            int y = rect[1];
            int a = rect[2];
            int b = rect[3];

            minX = Math.min(minX, x);
            minY = Math.min(minY, y);

            maxX = Math.max(maxX, a);
            maxY = Math.max(maxY, b);

            area += (long) (a-x) * (b-y);

            String[] points = {
                x + "," + y,
                a + "," + y,
                x + "," + b,
                a + "," + b
            };

            for(String point: points){
                if(corners.contains(point)) corners.remove(point);
                else corners.add(point);
            }
        }

        long boundingArea = (long) (maxX - minX) * (maxY - minY);

        if(boundingArea != area) return false;

        if(corners.size() != 4) return false;

        return corners.contains(minX + "," + minY)
            && corners.contains(minX + "," + maxY)
            && corners.contains(maxX + "," + minY)
            && corners.contains(maxX + "," + maxY);
    }
}