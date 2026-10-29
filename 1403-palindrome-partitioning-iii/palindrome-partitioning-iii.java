class Solution {
    int n;
    int[][] changes;
    int[][] dp;
    public int palindromePartition(String s, int k) {
        n = s.length();

        dp = new int[n][k + 1];
        for(int[] row: dp) Arrays.fill(row, -1);

        changes = new int[n][n];
        
        for(int l = n-1; l >= 0; l--){
            for(int r = l; r < n; r++){
                if(l == r){
                    changes[l][r] = 0;
                }
                else if(s.charAt(l) == s.charAt(r)){
                    changes[l][r] = changes[l+1][r-1];
                }else{
                    changes[l][r] = 1 + changes[l+1][r-1];
                }
            }
        }
        return func(0, k);
    }

    private int func(int l, int k){
        if(k == 0) return l == n ? 0 : (int) 1e9;

        if(n - l < k) return (int) 1e9;

        if(dp[l][k] != -1) return dp[l][k];

        int res = (int) 1e9;
        for(int r = l; r <= n - k; r++){
            int cost = changes[l][r];
            int rem = func(r + 1, k - 1);

            res = Math.min(res, cost + rem);
        }
        return dp[l][k] = res;
    }
}