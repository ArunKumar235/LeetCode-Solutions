class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int total = 0;
        for(int w: weights){
            max = Math.max(max, w);
            total += w;
        }
        
        int l = max;
        int r = total;

        while(l < r){
            int mid = l + (r-l)/2;
            if(check(weights, days, mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }

    private boolean check(int[] weights, int days, int maxWeight){
        int day = 1;
        int weight = 0;
        for(int w: weights){
            weight += w;
            if(weight > maxWeight){
                weight = w;
                day++;

                if(day > days) return false;
            }
        }
        return true;
    }
}
