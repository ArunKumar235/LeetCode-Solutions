class Solution {
    public String longestPrefix(String s) {
        
        int[] lps = computeLPS(s);
        int max = lps[lps.length-1];
        if(max==0) return "";
        return s.substring(0,max);
    
    }

    public int[] computeLPS(String pattern){
        int i = 1;
        int len = 0;
        int[] lps = new int[pattern.length()];

        while(i<pattern.length()){
            if(pattern.charAt(i)==pattern.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            } else {
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