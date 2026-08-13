class Solution {
    int len;
    int[][] count;
    
    public int findMaxForm(String[] strs, int m, int n) {
        this.len = strs.length;
        this.count = new int[len][2];
        
        for(int i = 0; i<len; i++){
            for(char c: strs[i].toCharArray()){
                if(c == '0') count[i][0]++;
                if(c == '1') count[i][1]++;
            }
        }

        int[][][] dp = new int[len][m+1][n+1];

        for(int i = 0; i<len; i++){
            for(int j = 0; j<m+1; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return func(0, m, n, dp);
    }

    private int func(int idx, int rem0, int rem1, int[][][] dp){
        if(idx == len){
            return 0;
        }

        if(dp[idx][rem0][rem1] != -1) return dp[idx][rem0][rem1];

        int notTake = func(idx+1, rem0, rem1, dp);
        
        int take = 0;
        if(count[idx][0] <= rem0 && count[idx][1] <= rem1)
            take = 1 + func(idx+1, rem0 - count[idx][0], rem1 - count[idx][1], dp);

        return dp[idx][rem0][rem1] = Math.max(take, notTake);
    }
}