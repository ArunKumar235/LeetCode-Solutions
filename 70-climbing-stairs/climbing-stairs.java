class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        int a = 1;
        int b = 1;
        for(int i = 0; i<n; i++){
            int c = a+b;
            b = a;
            a = c;
        }
        return b;
    }
}