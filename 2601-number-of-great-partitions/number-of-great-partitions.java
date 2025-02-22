import java.math.BigInteger;

class Solution {
    private static final int MOD = (int) (1e9 + 7);

    public int countPartitions(int[] nums, int k) {
        int N = nums.length;
        long total = 0;
        for (int num : nums) total += num;

        if (total < 2L * k) return 0;

        int[] dp = new int[k];
        dp[0] = 1;

        for (int num : nums) {
            for (int t = k - 1; t >= num; t--) {
                dp[t] = (int) (((long) dp[t] + dp[t - num]) % MOD);
            }
        }

        int invalid = 0;
        for (int t = 0; t < k; t++) {
            invalid = (invalid + dp[t]) % MOD;
        }
        invalid = (2 * invalid) % MOD;

        int totalPar = BigInteger.valueOf(2)
                          .modPow(BigInteger.valueOf(N), BigInteger.valueOf(MOD))
                          .intValue();

        return (MOD + totalPar - invalid) % MOD;
    }
}
