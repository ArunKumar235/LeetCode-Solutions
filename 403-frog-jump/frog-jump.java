class Solution {
    public boolean canCross(int[] stones) {

        if(stones[1]-stones[0] != 1) return false;

        int N = stones.length;
        
        int[][] dp = new int[N][N];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        // 0 - stone
        // 1 - water

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<stones.length; i++){
            map.put(stones[i], i);
        }

        return rec(1, 1, stones, map, dp)==0;
    }

    private int rec(int curr, int k, int[] arr, Map<Integer, Integer> map, int[][] dp){
        if(curr==arr.length-1) return 0;

        if(dp[curr][k] != -1) return dp[curr][k];

        int res = 1;
        
        if(map.containsKey(arr[curr]+k-1)){
            if(k-1!=0) 
            if(rec(map.get(arr[curr]+k-1), k-1, arr, map, dp)==0) res = 0;
        }

        if(map.containsKey(arr[curr]+k)){
            if(rec(map.get(arr[curr]+k), k, arr, map, dp)==0) res = 0;
        }

        if(map.containsKey(arr[curr]+k+1)){
            if(rec(map.get(arr[curr]+k+1), k+1, arr, map, dp)==0) res = 0;
        }

        return dp[curr][k] = res;
    }
}