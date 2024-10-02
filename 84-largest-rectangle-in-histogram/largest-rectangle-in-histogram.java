class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<block> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for(int i = 0; i<n; i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek().height > heights[i]){
                block prev = stack.pop();
                start = prev.index;
                maxArea = Math.max(maxArea, prev.height*(i-prev.index));
            }
            stack.push(new block(heights[i], start));
        }
        while(!stack.isEmpty()){
            block prev = stack.pop();
            maxArea = Math.max(maxArea, prev.height*(n-prev.index));
        }
        return maxArea;
    }
}

class block{
    int height, index;
    public block(int height, int index){
        this.height = height;
        this.index = index;
    }
}