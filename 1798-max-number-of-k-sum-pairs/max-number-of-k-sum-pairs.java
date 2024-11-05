class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int num : nums){
            if(map.containsKey(k-num) && map.get(k-num)!=0) {
                map.replace(k-num, map.get(k-num)-1);
                res++;
            }else{
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return res;
    }
}