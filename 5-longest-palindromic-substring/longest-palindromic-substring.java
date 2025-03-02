class Solution {
    public String longestPalindrome(String s) {
        int N = s.length();
        if(N<=1) return s;
        boolean[][] dp = new boolean[N][N];

        int maxLen = 1;
        int start = 0;
        int end = 0;
        for(int i = 0; i<N; i++){
            dp[i][i] = true;
            for(int j = 0; j<i; j++){
                if(s.charAt(i)==s.charAt(j) && (i-j<=2 || dp[j+1][i-1])){
                    dp[j][i] = true;
                    if(i-j+1 > maxLen){
                        maxLen = i-j+1;
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}