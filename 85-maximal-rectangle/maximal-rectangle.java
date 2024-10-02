class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r][c];
        for(int j = 0; j<c; j++){
            dp[0][j] = matrix[0][j]-'0';
        }
        for(int i = 1; i<r; i++){
            for(int j = 0; j<c; j++){
                if(matrix[i][j]=='0') dp[i][j] = 0;
                else dp[i][j] = dp[i-1][j]+1;
            }
        }
        int maxArea = 0;
        for(int[] i: dp){
            int area = largestRectangleArea(i);
            maxArea = Math.max(maxArea, area);
            System.out.println(Arrays.toString(i));
        }
        return maxArea;
    }

    public static int largestRectangleArea(int[] heights) {
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

class box {
    int height, index;
    public box(int height, int index){
        this.height = height;
        this.index = index;
    }
}