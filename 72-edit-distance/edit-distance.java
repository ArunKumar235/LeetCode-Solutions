class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        int[][] dp = new int[l1][l2];

        return func(word1, word2, l1-1, l2-1, dp);
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