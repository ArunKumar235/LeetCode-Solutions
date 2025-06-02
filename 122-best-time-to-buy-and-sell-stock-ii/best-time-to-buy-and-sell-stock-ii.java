class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int aheadNotBuy = 0, aheadBuy = 0, currNotBuy = 0, currBuy = 0;
        
        for(int i = n-1; i>=0; i--){
            
            currNotBuy = Math.max(prices[i] + aheadBuy, 0 + aheadNotBuy);

            currBuy = Math.max(-prices[i] + aheadNotBuy, 0 + aheadBuy);


            aheadNotBuy = currNotBuy;
            aheadBuy = currBuy;
        }
        
        return aheadBuy;
    }
}