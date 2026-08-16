class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int total = 0;
        for(int pile: piles) total += pile;
        
        int aliceChoice1 = 0;
        int aliceChoice2 = 0;
        for(int i = 0; i<n; i+=2){
            aliceChoice1 += piles[i];
            aliceChoice2 += piles[i+1];
        }

        return aliceChoice1 > total - aliceChoice1 || aliceChoice2 > total - aliceChoice2;
    }
}