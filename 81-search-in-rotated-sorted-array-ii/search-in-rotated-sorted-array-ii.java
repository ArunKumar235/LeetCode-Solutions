class Solution {
    public boolean search(int[] nums, int t) {
        int s = 0;
        int e = nums.length-1;

        while(s<=e){
            int m = s + (e-s)/2;
            if(nums[m] == t) return true;
            // left half sorted
            if(nums[s]<nums[m]){
                if(t>=nums[s] && t<=nums[m]){
                    e = m-1;
                }else{
                    s = m+1;
                }    
            }
            // right half sorted
            else if(nums[m] < nums[s]){
                if(t>=nums[m] && t<=nums[e]){
                    s = m+1;
                }else{
                    e = m-1;
                }
            }
            // not able to find sorted half
            else{
                s++;
            }
        }
        return false;
    }
}