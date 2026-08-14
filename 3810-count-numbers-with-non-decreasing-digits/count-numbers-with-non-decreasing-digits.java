import java.math.BigInteger;

class Solution {
    int MOD = (int) 1e9 + 7;

    public int countNumbers(String l, String r, int b) {
        BigInteger left = new BigInteger(l);
        BigInteger right = new BigInteger(r);

        int rightCount = count(right, b);
        int leftCount = count(left.subtract(BigInteger.ONE), b);

        return (rightCount - leftCount + MOD) % MOD;
    }

    private int count(BigInteger num, int b){
        if(num.signum() < 0) return 0;

        String str = num.toString(b);
        int len = str.length();

        int[][][] dp = new int[len][2][b];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < 2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return func(str, 0, 0, 0, b, dp);
    }

    // tight - 0 - previous digits are equal
    // tight - 1 - smaller digit occurred previously

    private int func(String str, int idx, int tight, int prev, int b, int[][][] dp){
        if(idx == str.length()) return 1;

        if(dp[idx][tight][prev] != -1) return dp[idx][tight][prev];

        int limit = tight == 1 ? b - 1 : str.charAt(idx) - '0';

        long ans = 0;

        for(int d = prev; d <= limit; d++){
            int newTight = (tight == 0 && d == limit) ? 0 : 1;

            ans += func(str, idx + 1, newTight, d, b, dp);
            ans %= MOD;
        }

        return dp[idx][tight][prev] = (int) ans;
    }
}