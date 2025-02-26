class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[][] dp = new int[l1][l2];
        for(int[] row: dp) Arrays.fill(row, -1);
        return rec(l1-1, l2-1, text1, text2, dp);
    }

    private int rec(int idx1, int idx2, String str1, String str2, int[][] dp){
        if(idx1<0 || idx2<0){
            return 0;
        }
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        
        if(str1.charAt(idx1)==str2.charAt(idx2)){
            return dp[idx1][idx2] = 1 + rec(idx1-1, idx2-1, str1, str2, dp);
        }
        int move1 = rec(idx1-1, idx2, str1, str2, dp);
        int move2 = rec(idx1, idx2-1, str1, str2, dp);

        return dp[idx1][idx2] = Math.max(move1, move2);
    }
}