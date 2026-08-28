class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int pile: piles) max = Math.max(max, pile);

        int l = 1;
        int r = max;
        while(l < r){
            int mid = l + (r -l)/2;

            if(check(piles, h, mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }

    private boolean check(int[] piles, int h, int k){
        int time = 0;
        for(int pile: piles){
            time += (pile + k - 1) / k;
            if(time > h) return false;
        }
        return true;
    }
}