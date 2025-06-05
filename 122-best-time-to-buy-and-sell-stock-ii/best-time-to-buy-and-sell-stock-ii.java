class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int netBuyProfit = 0;
        int netSellProfit = 0;

        for(int i = n-1; i>=0; i--){
            
            int buy = -prices[i] + netSellProfit;
            int skip1 = netBuyProfit;
            int currBuyProfit = Math.max(buy, skip1);
            
            int sell = prices[i] + netBuyProfit;
            int skip2 = netSellProfit;
            int currSellProfit = Math.max(sell, skip2);
            

            netBuyProfit = currBuyProfit;
            netSellProfit = currSellProfit;
        }

        return netBuyProfit;
    }
}