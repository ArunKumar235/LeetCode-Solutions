class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;
        for(char ch: s.toCharArray()){
            sum+=sums((int)ch - 'a' + 1);
        }
        while(k>1){
            sum = sums(sum);
            k--;
        }
        return sum;
    }

    public int sums (int n){
        int s = 0;
        while(n>0){
            s+=n%10;
            n/=10;
        }
        return s;
    }
}