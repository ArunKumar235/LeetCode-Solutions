class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for(int i = 0; i<=n; i++){
            arr[i] = count(i);
        }
        return arr;
    }

    public int count(int n){
        int c = 0;
        while(n>0){
            if((n&1)==1){
                c++;
            }
            n=n>>1;
        }
        return c;
    }
}