class Solution {
    // a is left part, b is right part
    // a == b
    // a ^ a = b ^ a
    // 0 = a ^ b
    // when a ^ b = 0, then mid bisect point could be anywhere between i < j <=k
    // so count of triplets = k - i  
    public int countTriplets(int[] arr) {
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            int xor = arr[i];
            for(int k = i + 1; k < arr.length; k++){
                xor ^= arr[k];

                if(xor == 0) res += k - i;
            }
        }
        return res;
    }
}