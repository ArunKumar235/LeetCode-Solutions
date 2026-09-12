class Solution {
    public long countGood(int[] nums, int k) {
        long res = 0;
        
        Map<Integer, Integer> freq = new HashMap<>();
        int l = 0;
        long pairs = 0;

        for(int r = 0; r < nums.length; r++){
            pairs += freq.getOrDefault(nums[r], 0);

            freq.put(nums[r], freq.getOrDefault(nums[r], 0) + 1);
            
            while(pairs >= k){
                freq.put(nums[l], freq.get(nums[l]) - 1);
                
                pairs -= freq.get(nums[l++]);
            }
            res += l;
        }
        return res;
    }
}