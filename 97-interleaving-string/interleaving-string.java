class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        if (s3.length() == 0) return true;

        int m = s1.length();
        int n = s2.length();
        boolean[][] memo = new boolean[m + 1][n + 1];

        memo[0][0] = true;

        for (int i = 1; i <= m; i++) {
            memo[i][0] = memo[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int j = 1; j <= n; j++) {
            memo[0][j] = memo[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int k = i + j - 1;
                memo[i][j] = (memo[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k)) ||
                            (memo[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k));
            }
        }

        return memo[m][n];
    }

}