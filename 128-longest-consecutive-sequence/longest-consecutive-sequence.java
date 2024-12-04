class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int res = 0;
        for(int num: nums){
            int i = 1;
            if(!set.contains(num-1)){
                while(set.contains(num+i)) i++;
            }
            res = Math.max(res, i);
        }
        return res;        
    }
}