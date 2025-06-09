class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int res = 0;
        for(int i = 0; i<n; i++){
            res = Math.max(res, dfs(i, new boolean[n], bombs));
        }
        return res;
    }

    private int dfs(int idx, boolean[] blown, int[][] bombs){
        int count = 1;
        blown[idx] = true;
        int n = bombs.length;
        for(int i = 0; i<n; i++){
            if(!blown[i] && inRange(bombs[idx], bombs[i])){
                count += dfs(i, blown, bombs);
            }
        }
        return count;
    }

    private boolean inRange(int[] cell1, int[] cell2){
        long dx = cell1[0]-cell2[0];
        long dy = cell1[1]-cell2[1];
        long range = cell1[2];
        return (long) dx*dx + dy*dy <= (long) range*range;
    }
}