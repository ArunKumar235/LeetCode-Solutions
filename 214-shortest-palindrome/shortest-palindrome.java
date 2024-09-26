class Solution {
    public String shortestPalindrome(String s) {
        int len = s.length();
        s = s+'_'+new StringBuilder(s).reverse().toString();
        int[] lps = new int[s.length()];
        int streakIndex = 0;
        for(int index = 1; index<s.length(); ){
            if(s.charAt(streakIndex) == s.charAt(index)){
                lps[index] = streakIndex+1;
                index++;
                streakIndex++;
            }else{
                if(streakIndex!=0){
                    streakIndex = lps[streakIndex-1];
                }else{
                    lps[index] = 0;
                    index++;
                }
            }
        }
        int l = lps[lps.length-1];
        String org = s.substring(0,len);
        return new StringBuilder(org.substring(l)).reverse().toString()+org;
    }
}