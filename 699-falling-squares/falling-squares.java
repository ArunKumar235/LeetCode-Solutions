class Solution {
    int[] heights;

    private void update(int l, int r, int h){
        for(int i = l; i <= r; i++){
            heights[i] = Math.max(heights[i], h);
        }
    }

    private int query(int l, int r){
        int h = 0;
        for(int i = l; i <= r; i++){
            h = Math.max(h, heights[i]);
        }
        return h;
    }

    public List<Integer> fallingSquares(int[][] positions) {
        TreeSet<Integer> x = new TreeSet<>();
        for(int[] pos: positions){
            int l = pos[0];
            int h = pos[1];
            x.add(l);
            x.add(l + h -1);
        }
        this.heights = new int[x.size()];
        
        // Co-ordinate compress 10^8 range to 2N
        // compressed idx -> coord value
        List<Integer> xVal = new ArrayList<>(x);
        // coord value -> idx
        Map<Integer, Integer> xCoord = new HashMap<>();
        for(int i = 0; i < xVal.size(); i++){
            xCoord.put(xVal.get(i), i);
        }

        List<Integer> ans = new ArrayList<>();
        int maxH = 0;

        for(int[] pos: positions){
            int l = xCoord.get(pos[0]);
            int r = xCoord.get(pos[0] + pos[1] - 1);
            
            int h = query(l, r) + pos[1];
            update(l, r, h);

            maxH = Math.max(maxH, h);
            ans.add(maxH);
        }
        return ans;
    }
}