class Solution {
    public int findIntegers(int n) {
        String str = Integer.toString(n, 2);
        int len = str.length();

        int[][][] dp = new int[len][2][2];

        for(int i = 0; i<len; i++){
            for(int j = 0; j<2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return func(str, 0, 0, 0, dp, len);
    }

    // tight - 0 - previously equal value
    // tight - 1 - previously lower value
    
    private int func(String str, int idx, int prev, int tight, int[][][] dp, int len){
        if(idx == len) return 1;

        if(dp[idx][prev][tight] != -1) return dp[idx][prev][tight];

        int limit = tight == 1 ? 1 : str.charAt(idx) - '0';

        int ans = 0;

        for(int d = 0; d <= limit; d++){
            if(prev == 1 && d == 1) continue;

            int newTight = tight;

            if(tight == 0 && d < limit){
                newTight = 1;
            }

            ans += func(str, idx + 1, d, newTight, dp, len);
        }

        return dp[idx][prev][tight] = ans;
    }
}