class Solution {
    public int findMaximumLength(int[] nums) {
        int n = nums.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++){
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[] dp = new int[n + 1];
        int[] previous = new int[n + 2];

        for (int i = 1; i <= n; i++){
            // Best previous boundary available for i
            previous[i] = Math.max(previous[i], previous[i - 1]);

            // Make one more segment
            dp[i] = dp[previous[i]] + 1;

            // previous segment:
            // prefix[i] - prefix[previous[i]]

            // Next segment must have at least the same sum:
            // prefix[j] - prefix[i]
            
            // prefix[j] - prefix[i] >= prefix[i] - prefix[previous[i]]
            // prefix[j] >= 2 * prefix[i] - prefix[previous[i]]
            
            long target = 2 * prefix[i] - prefix[previous[i]];

            int j = lowerBound(prefix, target);

            previous[j] = i;
        }
        return dp[n];
    }

    private int lowerBound(long[] arr, long target){
        int left = 0;
        int right = arr.length;

        while (left < right){
            int mid = left + (right - left) / 2;

            if(arr[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}