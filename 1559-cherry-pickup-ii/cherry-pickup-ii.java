class Solution {
    public int cherryPickup(int[][] arr) {
        int R = arr.length;
        int C = arr[0].length;

        int[][][] dp = new int[R][C][C];

        // Base case - Possible positions at last row
        for(int c1 = 0; c1<C; c1++){
            for(int c2 = 0; c2<C; c2++){
                if(c1==c2) dp[R-1][c1][c2] = arr[R-1][c1];
                else dp[R-1][c1][c2] = arr[R-1][c1] +arr[R-1][c2]; 
            }
        }

        // Tabulation
        for(int r = R-2; r>=0; r--){
            for(int c1 = 0; c1<C; c1++){
                for(int c2 = 0; c2<C; c2++){
                    int max = 0;
                    for(int i = -1; i<=1; i++){
                        for(int j = -1; j<=1; j++){
                            if(c1+i >= 0 && c1+i < C && c2+j>=0 && c2+j<C){        
                                max = Math.max(max, dp[r+1][c1+i][c2+j]);
                            }
                        }
                    }
                    if(c1!=c2) max += arr[r][c1]+arr[r][c2];
                    else max += arr[r][c1];
                     dp[r][c1][c2] = max;
                }
            }
        }

        return dp[0][0][C-1];
    }
}