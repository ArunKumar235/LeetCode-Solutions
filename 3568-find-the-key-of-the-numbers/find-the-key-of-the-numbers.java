class Solution {
    public int generateKey(int a, int b, int c) {
        int z =  Math.min(d(a), Math.min(d(b),d(c)));
        int x =  Math.min(f(a), Math.min(f(b),f(c)));
        int v =  Math.min(g(a), Math.min(g(b),g(c)));
        int n =  Math.min(a%10, Math.min(b%10,c%10));
        return (z*1000 + x*100 + v*10 + n);
    }

    public int d(int n){
        return (n/1000);
    }
    public int f(int n){
        return ((n/100)%10);
    }
    public int g(int n){
        return ((n/10)%10);
    }
}