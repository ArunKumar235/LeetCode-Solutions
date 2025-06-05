class Solution {
    int FEE;
    public int maxProfit(int[] prices, int fee) {
        FEE = fee;
       int n = prices.length;
        int[][] memo = new int[n][2];
        for(int[] arr: memo){
            Arrays.fill(arr, -1);
        }
        return func(0, 0, prices, memo);
    }

    private int func(int idx, int inHand, int[] arr, int[][] memo){
        if(idx==arr.length) return 0;

        if(memo[idx][inHand]!=-1) return memo[idx][inHand];

        if(inHand==0){
            int buy = -arr[idx] + func(idx+1, 1, arr, memo);
            int skip = func(idx+1, inHand, arr, memo);

            memo[idx][inHand] = Math.max(buy, skip);
        }
        else{
            int sell = -FEE + arr[idx] + func(idx+1, 0, arr, memo);
            int skip = func(idx+1, inHand, arr, memo);

            memo[idx][inHand] = Math.max(sell, skip);
        }

        return memo[idx][inHand];
    }
}