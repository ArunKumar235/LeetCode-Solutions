class Solution {
    boolean[][] isPal;
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        isPal = new boolean[n][n];

        for(int l = n-1; l >= 0; l--){
            for(int r = l; r < n; r++){
                if(s.charAt(l) == s.charAt(r) && (r-l <= 2 || isPal[l+1][r-1])){
                    isPal[l][r] = true;
                }
            }
        }
        return func(0, s, dp) - 1;
    }

    private int func(int l, String s, int[] dp){
        if(l == s.length()) return 0;
        if(dp[l] != -1) return dp[l];

        int res = Integer.MAX_VALUE;
        for(int k = l; k < s.length(); k++){
            if(isPal[l][k]){
                res = Math.min(res, 1 + func(k+1, s, dp));
            }
        }
        return dp[l] = res;
    }
}