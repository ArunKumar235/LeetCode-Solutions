class Solution {
    public int minDistance(String a, String b) {
        int l1 = a.length();
        int l2 = b.length();

        int[][] dp = new int[l1+1][l2+1];

        for(int i = 0; i<=l1; i++){
            dp[i][0] = i;
        }
        for(int j = 0; j<=l2; j++){
            dp[0][j] = j;
        }

        for(int i = 1; i<=l1; i++){
            for(int j = 1; j<=l2; j++){
                if(a.charAt(i-1)!=b.charAt(j-1)){
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                }else{
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[l1][l2];

    }

    private int func(String a, String b, int i, int j, int[][] dp){
        if(i<0) return j+1; // insertions
        if(j<0) return i+1; // deletions

        if(dp[i][j] !=0 ) return dp[i][j];
        
        if(a.charAt(i)==b.charAt(j)) return dp[i][j] = func(a, b, i-1, j-1, dp);

        else return dp[i][j] = 1 + Math.min( 
            func(a, b, i, j-1, dp), // insert
            Math.min( func(a, b, i-1, j, dp), // delete
                func(a, b, i-1, j-1, dp) // replace
            )
        );
    }
}