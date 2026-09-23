class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);

        int max = rewardValues[rewardValues.length - 1];
        int size = (2 * max + 63) / 64 + 1;
        long[] dp = new long[size];

        dp[0] = 1L; // reward 0

        for (int val : rewardValues) {
            int wordShift = val / 64;
            int bitShift = val % 64;

            int lastWord = (val - 1) / 64;

            for (int i = lastWord; i >= 0; i--) {
                long bits = dp[i];

                // Remove sums >= val.
                if (i == lastWord && (val % 64) != 0) {
                    bits &= (1L << (val % 64)) - 1;
                }

                if (bits == 0) continue;

                int j = i + wordShift;

                dp[j] |= bits << bitShift;

                if (bitShift != 0) {
                    dp[j + 1] |= bits >>> (64 - bitShift);
                }
            }
        }

        // Find largest achievable reward.
        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i] != 0) {
                return (i << 6) + (63 - Long.numberOfLeadingZeros(dp[i]));
            }
        }

        return 0;
    }
}