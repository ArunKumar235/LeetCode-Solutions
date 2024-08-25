class Solution {
    public int[] getFinalState(int[] arr, int k, int multiplier) {
        for(int i = 0; i<k; i++){
            int min = arr[0];
            int in  = 0;
            for(int j = 1; j<arr.length; j++){
                if(min>arr[j]){
                    min = arr[j];
                    in = j;
                }
            }
            arr[in] *= multiplier;
        }
        return arr;
    }
}