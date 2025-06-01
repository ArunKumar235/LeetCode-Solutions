class Solution {
    public boolean repeatedSubstringPattern(String s) {
int n = s.length();
        int[] lps = computeLPS(s);
        int last = lps[n-1];
        return last != 0 && n % (n - last) == 0;
    }

    private int[] computeLPS(String pattern){
        int[] lps = new int[pattern.length()];
        int i = 1;
        int len = 0;
        while(i<pattern.length()){
            if(pattern.charAt(i)==pattern.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len!=0){
                    len = lps[len-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

}