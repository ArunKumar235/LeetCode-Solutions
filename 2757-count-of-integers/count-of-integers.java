class Solution {
    int MOD = (int) 1e9 + 7;
    public int count(String num1, String num2, int min_sum, int max_sum) {

        int cnt2 = counts(num2, min_sum, max_sum);
        int cnt1 = counts(num1, min_sum, max_sum);

        int add = valid(num1, min_sum, max_sum) ? 1 : 0;

        return (cnt2 - cnt1 + add + MOD) % MOD;
    }

    private int counts(String str, int min_sum, int max_sum){
        int len = str.length();

        int[][][] dp = new int[len][2][max_sum + 1];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < 2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return func(str, 0, 0, 0, min_sum, max_sum, dp);
    }

    // tight - 0 - prev digits are equal to str
    // tight - 1 - smaller digit occurred

    private int func(String str, int idx, int tight, int sum, int min_sum, int max_sum, int[][][] dp){

        if(sum > max_sum) return 0;

        if(idx == str.length()) return sum >= min_sum ? 1 : 0;

        if(dp[idx][tight][sum] != -1) return dp[idx][tight][sum];

        int limit = tight == 1 ? 9 : str.charAt(idx) - '0';

        long ans = 0;

        for(int d = 0; d <= limit; d++){
            int newTight = (tight == 0 && d == limit) ? 0 : 1;

            ans += func(str, idx + 1, newTight, sum + d, min_sum, max_sum, dp);

            ans %= MOD;
        }

        return dp[idx][tight][sum] = (int) ans;
    }

    private boolean valid(String str, int min_sum, int max_sum){
        int sum = 0;

        for(char c : str.toCharArray()) sum += c - '0';
        
        return sum >= min_sum && sum <= max_sum;
    }
}