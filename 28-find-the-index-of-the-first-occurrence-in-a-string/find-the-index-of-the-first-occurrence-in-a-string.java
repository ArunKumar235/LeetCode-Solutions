class Solution {
    public int strStr(String haystack, String needle) {
        
        int[] lps = computeLPS(needle);

        int i = 0;
        int j = 0;

        while(i<haystack.length()){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;

                if(j==needle.length()){
                    return i-j;
                }
            }else{
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return -1;
    
    }

    private int[] computeLPS(String pattern){
        int i = 1;
        int len = 0;
        int[] lps = new int[pattern.length()];
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