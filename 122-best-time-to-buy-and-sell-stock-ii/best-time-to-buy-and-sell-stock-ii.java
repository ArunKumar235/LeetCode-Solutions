class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] ahead = new int[2];
        int[] curr = new int[2];
        for(int i = n-1; i>=0; i--){
            for(int j = 0; j<=1; j++){
                
                if(j==0){
                    curr[j] = Math.max(0+ahead[0], -prices[i]+ahead[1]);
                }else{
                    curr[j] = Math.max(0+ahead[1], prices[i]+ahead[0]);
                }
                ahead[0] = curr[0];
                ahead[1] = curr[1];
            }
        }
        return ahead[0];
    }
}