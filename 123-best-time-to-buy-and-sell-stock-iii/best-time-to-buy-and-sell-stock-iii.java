class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        Integer[][][] memo = new Integer[n][2][3];
        return func(0, 0, prices, 2, memo);    
    }

    private int func(int idx, int inHand, int[] arr, int opLeft, Integer[][][] memo){
        if(idx==arr.length || opLeft==0) return 0;

        if(memo[idx][inHand][opLeft] != null) return memo[idx][inHand][opLeft];
        
        if(inHand==0){
            int buy = -arr[idx] + func(idx+1, 1, arr, opLeft, memo);
            int skip = func(idx+1, 0, arr, opLeft, memo);

            memo[idx][inHand][opLeft] = Math.max(buy, skip);
        } 
        else{
            int sell = arr[idx] + func(idx+1, 0, arr, opLeft-1, memo);
            int skip = func(idx+1, 1, arr, opLeft, memo);

            memo[idx][inHand][opLeft] = Math.max(sell, skip);
        }
        return memo[idx][inHand][opLeft];
    }

}