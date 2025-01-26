class Solution {
    public int maxSatisfaction(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        
        int pre = 0;
        int res = 0;

        for(int i = n-1; i>=0; i--){
            pre+=arr[i];
            if(pre<0) break;
            res+=pre;
        }
        return res;
    }
}