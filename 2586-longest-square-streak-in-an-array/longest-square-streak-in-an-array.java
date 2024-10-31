class Solution {
    public int longestSquareStreak(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        int res = -1;
        for(int i = nums.length-1; i>=0; i--){
            int val = nums[i]*nums[i];
            map.put(nums[i], map.getOrDefault(val, 0)+1);
            res = Math.max(map.get(nums[i]), res);
        }
        return res==1 ? -1 : res;
    }
}