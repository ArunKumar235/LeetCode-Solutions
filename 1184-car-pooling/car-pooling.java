class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] arr = new int[1001];
        for(int[] i: trips){
            for(int j = i[1]; j<i[2]; j++){
                arr[j]+=i[0];
                if(arr[j]>capacity){
                    return false;
                }
            }
        }
        return true;
    }
}