class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String str = String.valueOf(n);
        int len = str.length();

        int[][][] dp = new int[len][2][2];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < 2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return func(str, 0, 0, 0, dp, digits);
    }

    // tight - 0 - previous digits are equal to n
    // tight - 1 - already smaller than n

    // begin - 0 - number has not started
    // begin - 1 - number has started

    private int func(String str, int idx, int tight, int begin, int[][][] dp, String[] digits){
        if(idx == str.length()) return begin == 1 ? 1 : 0;
        
        if(dp[idx][tight][begin] != -1) return dp[idx][tight][begin];
        
        int ans = 0;

        int limit = tight == 1 ? 9 : str.charAt(idx) - '0';

        if(begin == 0){
            ans += func(str, idx + 1, 1, 0, dp, digits);
        }

        for(String digit : digits){
            int d = digit.charAt(0) - '0';
            if(d > limit) break;

            int newTight = tight;

            if(tight == 0 && d < limit){
                newTight = 1;
            }

            ans += func(str, idx + 1, newTight, 1, dp, digits);
        }

        return dp[idx][tight][begin] = ans;
    }
}