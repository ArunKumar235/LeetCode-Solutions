class Solution {
    int trans;
    public int maxProfit(int K, int[] prices) {
        trans = 2*K;
        int[][] memo = new int[prices.length][trans];
        for(int[] arr: memo){
            Arrays.fill(arr, -1);
        }
        return func(0, 0, prices, memo);
    }
    private int func(int idx, int op, int[] arr, int[][] memo){
        if(idx==arr.length || op==trans) return 0;

        if(memo[idx][op] != -1) return memo[idx][op];
        
        if(op%2==0){
            int buy = -arr[idx] + func(idx+1, op+1, arr, memo);
            int skip = func(idx+1, op, arr, memo);

            memo[idx][op] = Math.max(buy, skip);
        
        }else{
            int sell = arr[idx] + func(idx+1, op+1, arr, memo);
            int skip = func(idx+1, op, arr, memo);

            memo[idx][op] = Math.max(sell, skip);
        }

        return memo[idx][op];
    }
}