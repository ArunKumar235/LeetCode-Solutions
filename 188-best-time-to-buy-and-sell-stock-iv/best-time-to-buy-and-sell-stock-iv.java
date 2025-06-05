class Solution {
    public int maxProfit(int K, int[] prices) {
        int n = prices.length;
        
        int[][] curr = new int[2][K+1];
        int[][] after = new int[2][K+1];

        for(int i = n-1; i>=0; i--){
            for(int k = 0; k<=K; k++){
                if(k==0){
                    curr[0][0] = after[0][0];
                    curr[1][0] = after[1][0];
                }else{
                    int buy = -prices[i] + after[1][k];
                    int skip1 = after[0][k];
                    
                    curr[0][k] = Math.max(buy, skip1);

                    int sell = prices[i] + after[0][k-1];
                    int skip2 = after[1][k];

                    curr[1][k] = Math.max(sell, skip2);
                }
            }
            after = curr.clone();
        }

        return after[0][K];
    }
}