class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if( bloomDay.length < (long) m * k) return -1;
        
        int max = 0;
        for(int bloom: bloomDay) max = Math.max(max, bloom);

        int l = 1;
        int r = max;

        while(l < r){
            int mid = l + (r-l)/2;

            if(check(bloomDay, m, k, mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }

    private boolean check(int[] bloomDay, int m, int k, int dayLimit){
        int count = 0;
        int continous = 0;
        
        for(int bloom: bloomDay){
            if(bloom <= dayLimit){
                continous++;

                if(continous == k){
                    count++;
                    continous = 0;

                    if(count == m) return true;
                }
            }else{
                continous = 0;
            }
        }
        return false;
    }
}