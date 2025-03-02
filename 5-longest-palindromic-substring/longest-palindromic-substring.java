class Solution {
    public String longestPalindrome(String s) {
        int N = s.length();
        int maxLen = 0;
        String res = "";
        Boolean palin[][] = new Boolean[N][N];
        for(int i = 0; i<N; i++){
            for(int j = i; j<N; j++){
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

    private boolean isPalin(String str, int start, int end, Boolean[][] palin){
        while(start<end){
            if(str.charAt(start)!=str.charAt(end)) return palin[start][end] = false;
            if(palin[start][end]!=null) return palin[start][end];
            start++;
            end--;
        }
        return palin[start][end] = true;
    }
}