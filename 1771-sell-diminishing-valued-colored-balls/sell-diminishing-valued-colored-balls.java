class Solution {
    public int maxProfit(int[] inventory, int orders) {
        int max = 0;
        for(int ball: inventory) max = Math.max(max, ball);
        
        int l = 0;
        int r = max;

        while(l <= r){
            int mid = l + (r-l)/2;

            if(check(inventory, orders, mid)){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        return getProfit(inventory, orders, r);
    }
    
    int MOD = (int) 1e9 + 7;

    private int getProfit(int[] inventory, int orders, int minValue){
        long profit = 0;
        long remaining = orders;

        for(int ball: inventory){
            if(ball <= minValue) continue;

            long count = ball - minValue;

            profit += count * ( ball + ball - count + 1) / 2;
            profit %= MOD;

            remaining -= count;
        }

        if(remaining > 0){
            profit += (long) remaining * minValue;
        }

        return (int) (profit % MOD);
    }

    private boolean check(int[] inventory, int orders, int minValue){
        int order = 0;
        for(int ball: inventory){
            if(ball < minValue) continue;

            order += ball - minValue + 1;

            if(order >= orders) return true;
        }
        return false;
    }
}