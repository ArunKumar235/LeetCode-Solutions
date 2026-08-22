class Solution {
    int DRAW = 0;
    int MOUSE = 1;
    int CAT = 2;

    public int catMouseGame(int[][] graph) {
        int n = graph.length;

        // time - x(mouse position) - y(cat position)
        int[][][] dp = new int[6*n][n][n];

        for(int i = 0; i<6*n; i++)
            for(int j = 0; j<n; j++)
                Arrays.fill(dp[i][j], -1);

        return search(0, 1, 2, graph, dp);
    }

    private int search(int time, int mouse, int cat, int[][] graph, int[][][] dp){
        if(time == 6*graph.length) return DRAW;
        if(mouse == 0) return MOUSE;
        if(mouse == cat) return CAT;
        if(dp[time][mouse][cat] != -1) return dp[time][mouse][cat];

        boolean isMouse = time%2 == 0;

        if(isMouse){
            int result = CAT;

            for(int nextMouse: graph[mouse]){
                int nextRes = search(time+1, nextMouse, cat, graph, dp);
                
                if(nextRes == MOUSE) return dp[time][mouse][cat] = MOUSE;

                if(nextRes == DRAW) result = DRAW;
            }
            return dp[time][mouse][cat] = result;
        }
        else{
            int result = MOUSE;

            for(int nextCat: graph[cat]){
                if(nextCat == 0) continue;

                int nextRes = search(time+1, mouse, nextCat, graph, dp);

                if(nextRes == CAT) return dp[time][mouse][cat] = CAT;

                if(nextRes == DRAW) result = DRAW;
            }
            return dp[time][mouse][cat] = result;
        }
    }
}