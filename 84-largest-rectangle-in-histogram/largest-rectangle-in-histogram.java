class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<box> stack = new Stack<>();
        int maxArea = heights[0];
        for(int idx = 0; idx<heights.length; idx++){
            int start = idx;
            while (!stack.isEmpty() && heights[idx]<stack.peek().height){
                box prev = stack.pop();
                start = prev.index;
                maxArea =  Math.max((idx- prev.index) * prev.height, maxArea);
            }
            stack.push(new box(heights[idx], start));
        }
        while(!stack.isEmpty()){
            box prev = stack.pop();
            maxArea = Math.max(maxArea, prev.height*(heights.length - prev.index));
        }
        return maxArea;
    }
}

class box{
    int height, index;
    public box(int height, int index){
        this.height = height;
        this.index = index;
    }
}