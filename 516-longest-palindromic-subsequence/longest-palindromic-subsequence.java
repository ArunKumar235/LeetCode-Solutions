class Solution {
    public int longestPalindromeSubseq(String s) {
        String t = new StringBuilder(s).reverse().toString();

        int l = s.length();

        int[][] dp = new int[l+1][l+1];

        for(int i = 1; i<=l; i++){
            for(int j = 1; j<=l; j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[l][l];
    }
}