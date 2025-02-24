class Solution {
    public int change(int amount, int[] coins) {
        int[] prev = new int[amount+1];
        int[] curr = new int[amount+1];
        for(int i = 0; i<=amount; i++) if(i%coins[0]==0) prev[i] = 1;

        for(int i = 1; i<coins.length; i++){
            for(int j = 0; j<=amount; j++){
                int nottake = prev[j];
                int take = 0;
                if(j-coins[i]>=0) take = curr[j-coins[i]];
                
                curr[j] = nottake+take;
            }
            prev = curr;
            curr = new int[amount+1];
        }
        return prev[amount];
    }
}