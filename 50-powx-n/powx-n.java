class Solution {
    public double myPow(double x, int N) {
        if(x==1) return 1;
        long n = N;
        double res = 1;
        boolean isneg = n<0;
        n = Math.abs(n);
        while(n>0){
            if((n&1)==1){
                res*=x;
            }
            x*=x;
            n = n>>1;
        }
        if(isneg){
            return 1.0/res;
        }
        return res;
    }
}