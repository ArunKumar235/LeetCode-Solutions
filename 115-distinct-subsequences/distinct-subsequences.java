class Solution {
    public int numDistinct(String s, String t){
        int[][] dp = new int[s.length()][t.length()];
        for(int i = 0; i<s.length(); i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(dp,s,t,s.length()-1,t.length()-1);
    }
    public int helper(int[][] dp, String s, String t, int row, int col){
        if(col==-1){
            return 1;
        }if(row==-1){
            return 0;
        }if(dp[row][col]!=-1){
            return dp[row][col];
        }
        if(s.charAt(row)==t.charAt(col)){
            dp[row][col] = helper(dp,s,t,row-1,col) + helper(dp,s,t,row-1,col-1);
        }else{
            dp[row][col] = helper(dp,s,t,row-1, col);
        }
        return dp[row][col];
    }
}