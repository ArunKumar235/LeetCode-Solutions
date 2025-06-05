class Solution {
    public int maxProfit(int[] prices) {
        int[][] memo = new int[prices.length][2];
        for(int[] arr: memo) Arrays.fill(arr, -1);

        return func(0, 0, prices, memo);
    }

    private int func(int idx, int inHand, int[] arr, int[][] memo){
        if(idx==arr.length) return 0;
        if(memo[idx][inHand] != -1) return memo[idx][inHand];

        if(inHand==1){
            int sell = arr[idx] + func(idx+1, 0, arr, memo);
            int skip = func(idx+1, inHand, arr, memo);

            return memo[idx][inHand] = Math.max(sell, skip);
        
        }else{
            int buy = -arr[idx] + func(idx+1, 1, arr, memo);
            int skip = func(idx+1, inHand, arr, memo);

            return memo[idx][inHand] = Math.max(buy, skip);
        }
    }
}