class Solution {
    public String shortestPalindrome(String s) {
        int[] lps = computeLPS(s+"#"+new StringBuilder(s).reverse().toString());

        String rem = s.substring(lps[lps.length-1]);

        return new StringBuilder(rem).reverse().toString() + s;
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