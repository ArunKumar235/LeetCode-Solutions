class Solution {
    public int scoreOfParentheses(String s){
        int res = 0;
        int l = 0;
        for(int i = 0; i < s.length(); ++i){
            if (s.charAt(i) == '(') l++; 
            else l--;
            
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') res += 1 << l;
        }
        return res;
    }
}
