class Solution {
    public boolean isMatch(String s, String p) {
        int l1 = s.length();
        int l2 = p.length();

        int[][] dp = new int[l1][l2];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }

        return func(s, p, l1-1, l2-1, dp) == 1;
    }

    private int func(String s, String p, int i, int j, int[][] dp){
        if(i<0 && j<0) return 1;

        if(j<0 && i>=0) return 0;

        if(i<0 && j>=0){ // when s is over and p is not over, remaining p must be of *
            for(int k = 0; k<=j; k++) if(p.charAt(k) != '*') return 0;
            return 1;
        }

        if(dp[i][j]!=-1) return dp[i][j];

        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?') return dp[i][j] = func(s, p, i-1, j-1, dp);
        
        if(p.charAt(j)=='*') 
            return dp[i][j] = (func(s, p, i-1, j, dp)==1  // char covered
                || func(s, p, i, j-1, dp)==1) ? 1 : 0 ; // char not covered
        
        return dp[i][j] = 0;
    }
}