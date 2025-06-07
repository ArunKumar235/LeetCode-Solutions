class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] after = new int[n+1];
        int[] curr = new int[n+1];
        
        for(int ind = n-1; ind>=0; ind--){
            for(int prev_index = ind-1; prev_index >=-1; prev_index--){
                
                int notTake = 0 + after[prev_index +1];
        
                int take = 0;
        
                if(prev_index == -1 || nums[ind] > nums[prev_index]){                    
                    take = 1 + after[ind+1];
                }
        
                curr[prev_index+1] = Math.max(notTake,take);
                
            }
            after = curr.clone();
        }
        
        return after[0];
    }
}