class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        return rec(0, n-1, s, dp);
    }

    private int rec(int start, int end, String str, int[][] dp){
        if(start>end) return 0;
        if(start==end) return 1;
        
        if(dp[start][end]!=-1) return dp[start][end];

        if(str.charAt(start)==str.charAt(end)){
            return dp[start][end] = 2 + rec(start+1, end-1, str, dp);
        }else{
            return dp[start][end] = Math.max(rec(start+1, end, str, dp), rec(start, end-1, str, dp));
        }
    }
}