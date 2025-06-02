class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] arr: dp){
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        return func(0, 0, prices, dp);
    }

    private int func(int idx, int buy, int[] arr, int[][] dp){
        if(idx==arr.length) return 0;

        if(dp[idx][buy]!=Integer.MIN_VALUE) return dp[idx][buy];

        int op1=0 , op2=0;
        
        if(buy==0){
            op1 = 0 + func(idx+1, 0, arr, dp);
            op2 = -arr[idx] + func(idx+1, 1, arr, dp);
        }

        if(buy==1){
            op1 = 0 + func(idx+1, 1, arr, dp);
            op2 = arr[idx] + func(idx+1, 0, arr, dp);
        }

        return dp[idx][buy] = Math.max(op1, op2);
    }
}