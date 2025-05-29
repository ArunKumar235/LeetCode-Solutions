class Solution {
    public int numDistinct(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();

        int[] dp = new int[l2+1];

        dp[0] = 1;

        for(int i = 1; i<=l1; i++){
            for(int j = l2; j>0; j--){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[j] = dp[j] + dp[j-1];
                }
            }
        }
        return dp[l2];
    }
}