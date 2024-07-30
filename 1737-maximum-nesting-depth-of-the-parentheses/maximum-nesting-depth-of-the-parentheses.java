class Solution {
    public int maxDepth(String s) {
        int co = 0;
        int max = 0;
        for(char c: s.toCharArray()){
            if (c=='('){
                co++;
            }if (c==')'){
                co--;
            }
            max = Math.max(co,max);
        }
        return max;
    }
}