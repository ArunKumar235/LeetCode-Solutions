class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);
        int n = nums.length;
        int sum = 0;
        int count = 0;
        for(int num: nums){
            sum += num;
            if(prefixSum.containsKey(sum-k)){
                count+= prefixSum.get(sum-k);
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum,0)+1);
        }
        return count;
    }
}