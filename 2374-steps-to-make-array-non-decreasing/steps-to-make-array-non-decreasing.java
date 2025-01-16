class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        int[][] stack = new int[n][2];
        int r = 0;
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            int curTurn = 0;
            while (r > 0 && stack[r - 1][0] < nums[i]) {
                int[] cur = stack[--r];
                curTurn = Math.max(curTurn + 1, cur[1]);
            }
            stack[r][0] = nums[i];
            stack[r++][1] = curTurn;
            max = Math.max(max, curTurn);
        }
        return max;
    }
}