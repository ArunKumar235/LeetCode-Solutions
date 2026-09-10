class Solution {
    int MOD = (int) 1e9 + 7;
    public int sumSubarrayMins(int[] arr) {
        int[] prevSmallerOrEqualIdx = findPrevSmallerOrEqualIdx(arr);
        
        int[] nextSmallerIdx = findNextSmallerIdx(arr);

        long total = 0;

        for(int i = 0; i < arr.length; i++){
            long leftContribution = i - prevSmallerOrEqualIdx[i];
            long rightContribution = nextSmallerIdx[i] - i;

            long totalContributions = (leftContribution * rightContribution) % MOD;

            total += (totalContributions * arr[i]) % MOD;
            total %= MOD;
        }
        return (int) total;
    }

    private int[] findPrevSmallerOrEqualIdx(int[] arr){
        int n = arr.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }
        return res;
    }

    private int[] findNextSmallerIdx(int[] arr){
        int n = arr.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            res[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }
        return res;
    }
}

// 1  4  6  7  3  7  8  1
// 1  1  1  1  4  1  1  7 -> left contribution count
// 8  3  1  1  3  2  1  1 -> right contribution count
// 8  3  2  1 12  2  1  7 -> left * right
// 8 12 12  7 36 14  8  7 -> (left * right) * arr[i]  

// 1 1
// 1 1 -> left contribution count 
// 2 1 -> right contribution count
// 2 1 -> left * right
// 2 1 -> (left * right) * arr[i]