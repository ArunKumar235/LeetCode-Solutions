class Solution {
    int DRAW = 0;
    int MOUSE = 1;
    int CAT = 2;

    int MOUSE_TURN = 0;
    int CAT_TURN = 1;

    public int catMouseGame(int[][] graph) {
        int n = graph.length;

        // mouse - cat - turn
        int[][][] result = new int[n][n][2];

        // mouse - 0 - mouse win
        for(int cat = 1; cat<n; cat++){
            result[0][cat][MOUSE_TURN] = MOUSE;
            result[0][cat][CAT_TURN] = MOUSE;
        }
        // mouse == cat(!=0) - cat win
        for(int pos = 1; pos<n; pos++){
            result[pos][pos][MOUSE_TURN] = CAT;
            result[pos][pos][CAT_TURN] = CAT;
        }

        boolean changed = true;

        while(changed){
            changed = false;

            for(int mouse = 0; mouse<n; mouse++){
                for(int cat = 1; cat<n; cat++){

                    if(mouse == 0 || mouse == cat) continue;

                    // Mouse turn
                    if(result[mouse][cat][MOUSE_TURN] == DRAW){
                        boolean canWin = false;
                        boolean allLose = true;

                        for(int nextMouse : graph[mouse]){
                            int nextResult = result[nextMouse][cat][CAT_TURN];

                            if(nextResult == MOUSE){
                                canWin = true;
                                break;
                            }
                            if(nextResult != CAT) allLose = false;
                        }
                        if(canWin){
                            result[mouse][cat][MOUSE_TURN] = MOUSE;
                            changed = true;
                        }
                        else if(allLose){
                            result[mouse][cat][MOUSE_TURN] = CAT;
                            changed = true;
                        }
                    }

                    // Cat turn
                    if(result[mouse][cat][CAT_TURN] == DRAW){
                        boolean canWin = false;
                        boolean allLose = true;

                        for(int nextCat : graph[cat]){
                            if(nextCat == 0) continue;
                            int nextResult = result[mouse][nextCat][MOUSE_TURN];

                            if(nextResult == CAT){
                                canWin = true;
                                break;
                            }
                            if(nextResult != MOUSE) allLose = false;
                        }
                        if(canWin){
                            result[mouse][cat][CAT_TURN] = CAT;
                            changed = true;
                        }
                        else if(allLose){
                            result[mouse][cat][CAT_TURN] = MOUSE;
                            changed = true;
                        }
                    }
                }
            }
        }
        return result[1][2][MOUSE_TURN];
    }
}