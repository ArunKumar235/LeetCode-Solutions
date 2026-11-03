class Solution {
    public int maximalRectangle(char[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        int[] dp = new int[C];
        int area = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(matrix[i][j] == '0') dp[j] = 0;
                else dp[j]++;
            }
            area = Math.max(area, largestRectangleArea(dp, C));
        }
        return area;
    }

    private int largestRectangleArea(int[] arr, int n){
        Stack<Integer> st = new Stack<>();
        int area = 0;

        for(int r = 0; r <= n; r++){
            int currH = (r == n) ? 0 : arr[r];

            while(!st.isEmpty() && arr[st.peek()] > currH){
                int h = arr[st.pop()];
                int w = st.isEmpty() ? r : r - st.peek() - 1;

                area = Math.max(area, h * w);
            }
            if(r < n) st.push(r);
        }
        return area;
    }
}