class Solution {
    public int minFlips(int a, int b, int c) {
        int res = 0;
        while(a!=0 || b!=0 || c!=0){
            int abit = a&1;
            int bbit = b&1;
            int cbit = c&1;
            if((abit|bbit)!=cbit){
                if(abit==1 && bbit==1) res+=2;
                else res+=1;
            }
            a>>=1;
            b>>=1;
            c>>=1;
        }

        return res;
    }
}