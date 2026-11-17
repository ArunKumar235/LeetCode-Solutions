// Line Sweep + Coverage Segment Tree (Coordinate compressed)
class Solution {
    public double separateSquares(int[][] squares) {
        TreeSet<Integer> xSet = new TreeSet<>();

        int[][] events = new int[2 * squares.length][];
        int idx = 0;
        for(int[] square: squares){
            int x1 = square[0];
            int y1 = square[1];
            int l = square[2];
            
            int x2 = x1 + l;
            int y2 = y1 + l; 

            events[idx++] = new int[]{y1, +1, x1, x2};
            events[idx++] = new int[]{y2, -1, x1, x2};

            xSet.add(x1);
            xSet.add(x2);
        }
        // sort events by y coordinate
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        // Coordinate compress X coordinates, for processing in segment tree
        int[] xVal = new int[xSet.size()];
        Map<Integer, Integer> xIdx = new HashMap<>();
        idx = 0;

        for(int x: xSet){
            xVal[idx] = x;
            xIdx.put(x, idx);
            idx++;
        }

        SegmentTree st = new SegmentTree(xVal);

        double totalArea = 0;
        int prevY = events[0][0];

        // First pass: calculate total union area
        for(int i = 0; i < events.length; ){
            int y = events[i][0];

            totalArea += (double)(y - prevY) * st.query();

            // Process all events at the same Y together
            while(i < events.length && events[i][0] == y){
                int type = events[i][1];
                int x1 = events[i][2];
                int x2 = events[i][3];

                st.update(xIdx.get(x1), xIdx.get(x2), type);
                i++;
            }
            prevY = y;
        }

        double target = totalArea / 2.0;
        // Second pass: locate the slab containing half the area
        st = new SegmentTree(xVal);
        prevY = events[0][0];

        double accumlated = 0; // total union area until prevY

        for(int i = 0; i < events.length; ){
            int y = events[i][0];
            int width = st.query();
            int height = y - prevY;
            double area = (double) width * height;
            
            if(target <= accumlated + area && width != 0){
                double need = target - accumlated; 
                return prevY + need / width;
            }

            accumlated += area;

            while(i < events.length && events[i][0] == y){
                int type = events[i][1];
                int x1 = events[i][2];
                int x2 = events[i][3];

                st.update(xIdx.get(x1), xIdx.get(x2), type);
                i++;
            }
            prevY = y;
        }
        return prevY;
    }
}

// Segment tree represents intervals between adjacent X coordinates
class SegmentTree{
    int N;
    int[] xVal;
    
    int[] count;
    int[] covered;
    
    public SegmentTree(int[] xVal){
        this.xVal = xVal;
        this.N = xVal.length - 1;

        this.count = new int[4*N];
        this.covered = new int[4*N];
    }

    public int query(){
        return covered[0];
    }

    public void update(int ql, int qr, int type){
        update(ql, qr-1, type, 0, N-1, 0);
    }

    private void update(int ql, int qr, int type, int l, int r, int node){
        if(qr < l || r < ql) return;

        if(ql <= l && r <= qr){
            count[node] += type; // +1 for entry, -1 for exit
        } else{
            int mid = l + (r - l)/2;
            update(ql, qr, type, l, mid, 2*node + 1);
            update(ql, qr, type, mid+1, r, 2*node + 2);
        }

        if(count[node] > 0){
            covered[node] = xVal[r + 1] - xVal[l]; 
        }
        else if(l == r){
            covered[node] = 0;
        }
        else{
            covered[node] = covered[2*node + 1] + covered[2*node + 2];
        }
    }
}