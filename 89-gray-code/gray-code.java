class Solution {
    List<Integer> res;
    Set<Integer> visited = new HashSet<>();
    Stack<Integer> st = new Stack<>();

    public List<Integer> grayCode(int n) {
        visited.add(0);
        st.push(0);

        backtrack(0, n);

        return new ArrayList<>(st);
    }

    private boolean backtrack(int currVal, int n){
        if(visited.size() == (1<<n)){
            res = new ArrayList<>(st);
            return true;
        }    

        for(int bit = 0; bit < n; bit++){
            int newVal = currVal ^ (1<<bit);

            if(visited.contains(newVal)) continue;

            st.push(newVal);
            visited.add(newVal);

            if(backtrack(newVal, n)) return true;

            st.pop();
            visited.remove(newVal);
        }
        return false;
    }
}