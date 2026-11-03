class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int area = 0;
        for(int r = 0; r < heights.length; r++){
            while(!st.isEmpty() && heights[st.peek()] > heights[r]){
                int h = heights[st.pop()];
                int w = st.isEmpty() ? r : r - st.peek() - 1;
                area = Math.max(area, w * h);
            }
            st.push(r);
        }

        while(!st.isEmpty()){
            int h = heights[st.pop()];
            int w = st.isEmpty() ? heights.length : heights.length - st.peek() - 1;
            area = Math.max(area, w * h);
        }
        return area;
    }
}