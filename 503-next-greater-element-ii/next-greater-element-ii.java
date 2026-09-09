class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // store values in descending order
        Stack<Integer> st = new Stack<>();

        for(int i = 2*n - 1; i >=0; i--){
            while(!st.isEmpty() && nums[i%n] >= st.peek()){
                st.pop();
            }

            if(i < n){
                res[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(nums[i%n]);
        }
        return res;
    }
}