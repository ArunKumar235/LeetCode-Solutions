class Solution {
    public boolean canArrange(int[] arr, int k) {
        int [] freq = new int[k];
        for(int num: arr){
            int rem = num % k;
            if(rem<0) rem+=k;
            freq[rem]++;
        }
        if(freq[0] % 2 != 0){
            return false;
        }
        int start = 1;
        int end = k-1;
        while(start<end){
            if(freq[start++] != freq[end--]){
                return false;
            }
        }
        return true;
    }
}