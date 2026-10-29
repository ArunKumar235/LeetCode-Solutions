class Solution {
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);

        return func(0, s, dp) - 1;
    }

    private int func(int l, String s, int[] dp){
        if(l == s.length()) return 0;
        if(dp[l] != -1) return dp[l];

        int res = Integer.MAX_VALUE;
        for(int k = l; k < s.length(); k++){
            if(isPal(s, l, k)){
                res = Math.min(res, 1 + func(k+1, s, dp));
            }
        }
        return dp[l] = res;
    }

    private boolean isPal(String s, int l, int r){
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}