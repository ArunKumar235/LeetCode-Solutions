class Solution {
    public int countTriplets(int[] nums) {
        int[] count = new int[1<<16];
        
        for(int a: nums){
            for(int b: nums){
                count[a & b]++;
            }
        }

        int res = 0;
        for(int a: nums){
            for(int i = 0; i < count.length; i++){
                if((a & i) == 0) res += count[i];
            }
        }
        return res;
    }
}