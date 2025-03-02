class Solution {
    public String longestPalindrome(String s) {
        int N = s.length();
        int maxLen = 0;
        String res = "";
        Boolean palin[][] = new Boolean[N][N];
        for(int i = 0; i<N; i++){
            for(int j = i; j<N; j++){
                if(j-i+1<maxLen) continue;
                if(isPalin(s, i, j, palin)){
                    if(j-i+1>maxLen){
                        maxLen = j-i+1;
                        res = s.substring(i, j+1);
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalin(String s, int start, int end, Boolean[][] palin){
        if(start>=end) return true;
        
        if(palin[start][end]!=null) return palin[start][end];
        
        if(s.charAt(start)!=s.charAt(end)){
            return palin[start][end] = false;
        }
        return palin[start][end] = isPalin(s, start+1, end-1, palin);
    }
}