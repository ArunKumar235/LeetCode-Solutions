class Solution {
    public int numDistinct(String s, String t) {
        int l1 = s.length(); 
        int l2 = t.length();
        int[][] dp = new int[l1][l2];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return helper(s,t,l1-1,l2-1, dp);
    }

    public int helper(String a, String b, int i, int j, int[][] dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)) return dp[i][j] = helper(a,b,i-1,j-1, dp) + helper(a,b,i-1,j, dp);

        return dp[i][j] = helper(a,b,i-1,j, dp);
    }
}