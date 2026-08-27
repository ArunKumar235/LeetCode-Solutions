class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int max = 0;
        for(int q : quantities) max = Math.max(max, q);

        int l = 1;
        int r = max;
        
        while(l < r){
            int mid = l + (r-l)/2;
            if(check(quantities, n, mid)){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }

    private boolean check(int[] quants, int n, int maxQuant){
        int stores = 0;

        for (int q : quants){
            stores += (q + maxQuant - 1) / maxQuant;

            if(stores > n){
                return false;
            }
        }
        return true;
    }
}
