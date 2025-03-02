class Solution {
    public String longestPalindrome(String s) {
        int N = s.length();
        int maxLen = 0;
        String res = "";
        for(int i = 0; i<N; i++){
            for(int j = i; j<N; j++){
                if(isPalin(s, i, j)){
                    if(j-i+1>maxLen){
                        maxLen = j-i+1;
                        res = s.substring(i, j+1);
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalin(String str, int start, int end){
        while(start<end){
            if(str.charAt(start)!=str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}