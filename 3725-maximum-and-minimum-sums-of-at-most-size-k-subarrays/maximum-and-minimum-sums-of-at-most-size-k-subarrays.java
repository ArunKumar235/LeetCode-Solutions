class Solution {
    public long minMaxSubarraySum(int[] nums, int k) {
        long minimum = findSumOfMinOfAllSubArrays(nums, k);
        long maximum = findSumOfMaxOfAllSubArrays(nums, k);

        return maximum + minimum;
    }

    private long findSumOfMinOfAllSubArrays(int[] arr, int k){
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

            total += countSubarrays(left, right, k) * arr[i];
        }
        return total;
    }

    private long findSumOfMaxOfAllSubArrays(int[] arr, int k){
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

            left = Math.min(left, k);
            right = Math.min(right, k);

            total += countSubarrays(left, right, k) * arr[i];
        }
        return total;
    }

    // left  -> number of choices for the left boundary
    // right -> number of choices for the right boundary
    private long countSubarrays(int left, int right, int k) {
        left = Math.min(left, k);
        right = Math.min(right, k);

        // condition for valid pair : left + right - 1 <= k
        // condition for invalid pair : left + right - 1 > k
        if(left + right - 1 <= k){
            return 1L * left * right;
        }

        // for the first 'maxValidLeft' values of left all `right` choices are valid.
        // left <= k - (right - 1)
        int maxValidLeft = k - (right - 1);

        long count = 1L * maxValidLeft * right;

        // remaining left choices have decreasing valid-right counts
        // left choice left + (left - maxValidLeft) -> right - (left - maxValidLeft)
        // ...
        // left choice maxValidLeft + 2             -> right - 2
        // left choice maxValidLeft + 1             -> right - 1 
        // left choice maxValidLeft                 -> right
        // ...
        // left choice 2                            -> right 
        // left choice 1                            -> right 
        int remaining = left - maxValidLeft;
        
        long removed = 0;
        for(int i = 1; i <= remaining; i++){
            removed += i;
        }

        count += (1L * remaining * right) -  removed;

        return count;
    }
}