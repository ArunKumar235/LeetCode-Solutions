class Solution {
     public double myPow(double x, int n) {
        if (x == 1) return 1;
        long longN = n;
        double ans = solve(x, Math.abs(longN));
        if (longN < 0)
            return 1 / ans;
        return ans;
    }

    public double solve(double x, long n) {
        double ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ans;
    }
    
}