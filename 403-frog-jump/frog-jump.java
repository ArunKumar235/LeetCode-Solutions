class Solution {
    public boolean canCross(int[] stones) {
        if(stones[1] - stones[0] != 1) return false;
        
        int N = stones.length;

        int[][] dp = new int[N][N];

        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<N; i++){
            map.put(stones[i], i);
        }

        return rec(stones, 1, 1, map, dp);
    }

    private boolean rec(int[] stones, int i, int k, Map<Integer, Integer> map, int[][] dp) {
    if (i == stones.length - 1) return true;

    if (dp[i][k] != -1) return dp[i][k] == 1;

    boolean kp = false, k0 = false, k1 = false;

    // Jump k-1
    if (k > 1 && map.containsKey(stones[i] + k - 1)) {
        kp = rec(stones, map.get(stones[i] + k - 1), k - 1, map, dp);
    }
    // Jump k
    if (map.containsKey(stones[i] + k)) {
        k0 = rec(stones, map.get(stones[i] + k), k, map, dp);
    }
    // Jump k+1
    if (map.containsKey(stones[i] + k + 1)) {
        k1 = rec(stones, map.get(stones[i] + k + 1), k + 1, map, dp);
    }

    dp[i][k] = (kp || k0 || k1) ? 1 : 0;

    return dp[i][k] == 1;
}

}