class Solution {
    public int minDistance(String word1, String word2) {
        int LCS = lcs(word1, word2);
        int deletions1 = word1.length() - LCS;
        int deletions2 = word2.length() - LCS;

        return deletions1 + deletions2;
    }

    public int lcs(String str1, String str2){
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i = 1; i<=str1.length(); i++){
            for(int j = 1; j<=str2.length(); j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}