import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nextSmaller = findNextSmallerElements(arr);
        int[] prevSmaller = findPrevSmallerElements(arr);
        long total = 0;
        int mod = (int)(1e9 + 7);
        
        for (int i = 0; i < arr.length; i++) {
            int left = i - prevSmaller[i];
            int right = nextSmaller[i] - i;
            long contribution = (left * right * (long)arr[i]) % mod;
            total = (total + contribution) % mod;
        }
        
        return (int) total;
    }
    
    private int[] findNextSmallerElements(int[] arr) {
        int[] nextSmaller = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            nextSmaller[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        
        return nextSmaller;
    }
    
    private int[] findPrevSmallerElements(int[] arr) {
        int[] prevSmaller = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        
        return prevSmaller;
    }
}
