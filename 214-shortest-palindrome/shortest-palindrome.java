class Solution {
    public String shortestPalindrome(String s) {
        String org = s;
        StringBuilder pal = new StringBuilder(s);
        pal.reverse();
        pal = new StringBuilder(org+'_'+pal.toString());
        int streakIndex = 0;
        int[] lps = new int[pal.length()];
        for(int index = 1; index<pal.length(); ){
            if(pal.charAt(streakIndex)==pal.charAt(index)){
                lps[index] = streakIndex+1;
                streakIndex++;
                index++;
            }else{
                if(streakIndex!=0){
                    streakIndex = lps[streakIndex-1];
                }else{
                    lps[streakIndex] = 0;
                    index++;
                }
            }
        }
        int longestPrefixPal = lps[lps.length-1];
        StringBuilder rev = new StringBuilder(org.substring(longestPrefixPal, org.length()));
        return rev.reverse()+org;
    }
}