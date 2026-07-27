class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int res = 0;
        for(char c: s.toCharArray()){
            if(c == '('){
                st.push(c);
            }else{
                if(!st.isEmpty() && st.peek()=='('){
                    st.pop();
                }else{
                    res++;
                }
            }
        }
        return res + st.size();
    }
}