class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] seq = new int[n];
        int size = 0;

        for(int num: nums){
            int l = 0;
            int r = size;

            // find the first position having value greater than or equal to curr value
            while(l < r){
                int mid = l + (r-l)/2;

                if(seq[mid] < num){
                    l = mid + 1;
                }else{
                    r = mid;
                }
            }
            seq[l] = num;

            if(l == size) size++;
        }
        return size;
    }
}