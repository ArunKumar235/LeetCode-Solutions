class Solution {
    public int longestSquareStreak(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        int res = -1;
        for(int i = nums.length-1; i>=0; i--){
            int val = nums[i]*nums[i];
            if(map.containsKey(val)){
                map.put(nums[i], map.get(val)+1);
                res = Math.max(res, map.get(nums[i]));
            }else{
                map.put(nums[i], 1);
            }
        }
        return res;
    }
}