/* 
    A horizontal line sweeps from bottom to top over the shapes.
    Each shape contribute two events, open event on bottom line, close event on top line.
    On open event, the horizontal interval starts contributing to the area.
    On close event, the horizontal interval stops contributing to the area.
*/
class Solution {
    long MOD = (long) 1e9 + 7;
    public int rectangleArea(int[][] rectangles) {
        int OPEN = 0, CLOSE = 1;
        int[][] events = new int[rectangles.length * 2][3];

        int idx = 0;
        for(int[] rect: rectangles){
            int x1 = rect[0];
            int y1 = rect[1];
            int x2 = rect[2];
            int y2 = rect[3];

            events[idx++] = new int[]{y1, OPEN, x1, x2};
            events[idx++] = new int[]{y2, CLOSE, x1, x2};
        }

        // sort events by y asc
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> active = new ArrayList<>();
        int currY = events[0][0];

        long res = 0;
        for(int[] event: events){
            int y = event[0], type = event[1], x1 = event[2], x2 = event[3];

            // calculate query
            long query = 0;
            int currX = -1;
            for(int[] interval: active){
                currX = Math.max(currX, interval[0]);
                query += Math.max(interval[1] - currX, 0);
                currX = Math.max(currX, interval[1]);
            }

            res += query * (y - currY);

            if(type == OPEN){
                active.add(new int[]{x1, x2});
                Collections.sort(active, (a, b) -> Integer.compare(a[0], b[0]));
            }else{
                for(int i = 0; i < active.size(); i++){
                    if(active.get(i)[0] == x1 && active.get(i)[1] == x2){
                        active.remove(i);
                        break;
                    }
                }
            }
            currY = y;
        }
        return (int) (res % MOD);
    }
}