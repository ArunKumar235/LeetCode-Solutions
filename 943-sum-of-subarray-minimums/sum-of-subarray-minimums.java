class Solution {
    long MOD = (long) 1e9 + 7;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] prevSmallerOrEqual = new int[n];
        int[] nextSmaller = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            prevSmallerOrEqual[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            nextSmaller[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long total = 0;

        for(int i = 0; i < n; i++){
            int left = i - prevSmallerOrEqual[i];
            int right = nextSmaller[i] - i;

            total += (((left * right) % MOD) * arr[i]) % MOD;
            total %= MOD;
        }
        return (int) total;
    }
}