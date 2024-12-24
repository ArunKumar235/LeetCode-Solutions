class Solution {
    public int cherryPickup(int[][] arr) {
        int N = arr.length;
        int[][][] dp = new int[N][N][N];
        
        for(int[][] m : dp){
            for(int[] row : m){
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        dp[0][0][0] = arr[0][0];

        for(int r1 = 0; r1<N; r1++){
            for(int c1 = 0; c1<N; c1++){
                for(int c2 = 0; c2<N; c2++){

                    int r2 = r1+c1-c2;

                    if(r2<0 || r2>=N || arr[r1][c1] == -1 || arr[r2][c2] == -1) continue;

                    int cherry = Integer.MIN_VALUE;
                    if (r1 > 0 && r2 > 0) cherry = Math.max(cherry, dp[r1 - 1][c1][c2]);
                    if (r1 > 0 && c2 > 0) cherry = Math.max(cherry, dp[r1 - 1][c1][c2 - 1]);
                    if (c1 > 0 && r2 > 0) cherry = Math.max(cherry, dp[r1][c1 - 1][c2]);
                    if (c1 > 0 && c2 > 0) cherry = Math.max(cherry, dp[r1][c1 - 1][c2 - 1]);

                    if (cherry == Integer.MIN_VALUE) {
                        continue;
                    }

                    dp[r1][c1][c2] = cherry + arr[r1][c1];

                    if (r1 != r2 || c1 != c2) {
                        dp[r1][c1][c2] += arr[r2][c2];
                    }
                }
            }
        }

        return Math.max(0, dp[N-1][N-1][N-1]);
    }
}