class Solution {
    public long maximumProfit(int[] prices, int k) {
        Long[][][] memo = new Long[prices.length][3][2*k + 1];
        return  func(0, 0, 2*k, prices, memo);
    }   


    // 0 - nothing in hand
    // 1 - last op buy
    // 2 - last op sell, yet to buy

    private Long func(int idx, int inHand, int opLeft, int[] arr, Long[][][] memo){
        if(idx==arr.length && inHand==2) return Long.MIN_VALUE;
        if(idx==arr.length || opLeft==0) return 0L;
        if(memo[idx][inHand][opLeft] != null ) return memo[idx][inHand][opLeft];
        
        if(inHand==0){
            Long skip = func(idx+1, 0, opLeft, arr, memo);
            
            Long buy = -arr[idx] + func(idx+1, 1, opLeft-1, arr, memo);
            
            Long sell = arr[idx] + func(idx+1, 2, opLeft-1, arr, memo);

            return memo[idx][inHand][opLeft] = Math.max(skip, Math.max(buy, sell));
        }else if(inHand==1){    
            Long sell = arr[idx] + func(idx+1, 0, opLeft-1, arr, memo);

            Long skip = func(idx+1, 1, opLeft, arr, memo);
            
            return memo[idx][inHand][opLeft] = Math.max(skip, sell);
        }else{
            Long skip = func(idx+1, 2, opLeft, arr, memo);
            
            Long buy = -arr[idx] + func(idx+1, 0, opLeft-1, arr, memo);

            return memo[idx][inHand][opLeft] = Math.max(skip, buy);
        }
    }
}