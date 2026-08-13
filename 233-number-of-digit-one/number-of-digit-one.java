class Solution {
    public int countDigitOne(int n) {
        String str = String.valueOf(n);
        int len = str.length();

        int[][][] dp = new int[len][2][len + 1];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < 2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return func(str, 0, 0, 0, dp);
    }

    // tight - 0 - previous digits are equal to n
    // tight - 1 - previous digits are already smaller

    private int func(String str, int idx, int tight, int ones, int[][][] dp){
        if(idx == str.length()){
            return ones;
        }

        if(dp[idx][tight][ones] != -1){
            return dp[idx][tight][ones];
        }

        int limit = tight == 1 ? 9 : str.charAt(idx) - '0';
        int ans = 0;

        for(int d = 0; d <= limit; d++){
            int newTight = (tight == 0 && d == limit) ? 0 : 1;

            int newOnes = ones;
            if(d == 1){
                newOnes++;
            }

            ans += func(str, idx + 1, newTight, newOnes, dp);
        }

        return dp[idx][tight][ones] = ans;
    }
}