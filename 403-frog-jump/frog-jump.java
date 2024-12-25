class Solution {
    public boolean canCross(int[] stones) {
        if(stones[1] - stones[0] != 1) return false;
        
        int N = stones.length;
        
        int[][] dp = new int[N][N];
        
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i<N; i++){
            map.put(stones[i], i);
        }

        return rec(1,1,stones,map,dp);
    }

    // i represent the current index and k represent the previous jump size
    private boolean rec(int i, int k, int[] stones, HashMap<Integer, Integer> map, int[][] dp){
        if(i==stones.length-1) return true;
        if(dp[i][k] != -1) return dp[i][k]==1;

        boolean kp = false, k0 = false, k1 = false;

        // Jump K-1 steps only if there is a stone present over there
        if(k>1 && map.containsKey(stones[i]+k-1)){
            kp = rec(map.get(stones[i]+k-1), k-1, stones, map, dp);
        }

        // Jump K steps only if there is a stone present over there
        if(map.containsKey(stones[i]+k)){
            k0 = rec(map.get(stones[i]+k), k, stones, map, dp);
        }

        // Jump K+1 steps only if there is a stone present over there
        if(map.containsKey(stones[i]+k+1)){
            k1 = rec(map.get(stones[i]+k+1), k+1, stones, map, dp);
        }

        dp[i][k] = (kp || k0 || k1) ? 1 : 0;

        return dp[i][k] == 1;
    }
}