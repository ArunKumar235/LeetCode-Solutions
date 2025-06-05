class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int aheadBuy = 0, aheadNotBuy = 0, currBuy = 0, currNotBuy = 0;

        for(int i = n-1; i>=0; i--){
            
            int buy = - prices[i] + aheadNotBuy;
            int skip1 = aheadBuy;

            currBuy = Math.max(buy, skip1);

            int sell = -fee + prices[i] + aheadBuy;
            int skip2 = aheadNotBuy;

            currNotBuy = Math.max(sell, skip2);

            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;
        }

        return aheadBuy;
    }
}