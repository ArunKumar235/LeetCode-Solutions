class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < n; i++) {
            int nextUgly = Math.min(dp[index2] * 2, Math.min(dp[index3] * 3, dp[index5] * 5));
            dp[i] = nextUgly;
            if (nextUgly == dp[index2] * 2) index2++;
            if (nextUgly == dp[index3] * 3) index3++;
            if (nextUgly == dp[index5] * 5) index5++;
        }

        return dp[n - 1];
    }
}