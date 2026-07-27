class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        st.push(0);

        for(int i = 1; i<heights.length; i++){
            while(!st.isEmpty() && heights[i]< heights[st.peek()]){
                max = getMax(heights, st, max, i);
            }
            st.push(i);
        }
        
        int i = heights.length;
        while(!st.isEmpty()){
            max = getMax(heights, st, max, i);
        }
        return max;
    }

    private int getMax(int[] heights, Stack<Integer> st, int max, int i){
        int area;
        int popped = st.pop();
        if(st.isEmpty()){
            area = heights[popped] * i;
        }else{
            area = heights[popped] * (i-1-st.peek());
        }
        return Math.max(max, area);
    }
}