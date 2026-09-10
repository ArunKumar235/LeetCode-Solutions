class Solution {
    public long subArrayRanges(int[] nums) {
        long minimum = findSumOfMinOfAllSubArrays(nums);
        long maximum = findSumOfMaxOfAllSubArrays(nums);

        return maximum - minimum;
    }

    private long findSumOfMinOfAllSubArrays(int[] arr){
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

            total += (1L * left * right * arr[i]);
        }
        return total;
    }

    private long findSumOfMaxOfAllSubArrays(int[] arr){
        int n = arr.length;
        int[] prevLargerOrEqual = new int[n];
        int[] nextLarger = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                st.pop();
            }
            prevLargerOrEqual[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            nextLarger[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long total = 0;

        for(int i = 0; i < n; i++){
            int left = i - prevLargerOrEqual[i];
            int right = nextLarger[i] - i;

            total += (1L * left * right * arr[i]);
        }
        return total;
    }
}