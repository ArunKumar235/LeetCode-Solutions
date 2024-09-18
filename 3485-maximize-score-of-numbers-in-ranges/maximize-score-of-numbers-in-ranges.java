class Solution {
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        int n = start.length;

        long left = 0, right = Long.MAX_VALUE;
        while (left < right) {
            long mid = (right + left + 1) / 2;
            if (canChoose(start, d, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return (int) left;
    }

    private static boolean canChoose(int[] start, int d, long minDiff) {
        long chosen = start[0];
        for (int i = 1; i < start.length; i++) {
            if (chosen + minDiff > start[i] + d) {
                return false;
            }
            chosen = Math.max(chosen + minDiff, start[i]);
        }
        return true;
    }
}