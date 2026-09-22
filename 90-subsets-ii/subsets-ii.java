class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int len = 1 << nums.length;
        
        Set<List<Integer>> resSet = new HashSet<>();
        
        for(int i = 0; i < len; i++){
            List<Integer> ss = new ArrayList<>();
            for(int bit = 0; bit < nums.length; bit++){
                if((i & (1 << bit)) != 0){
                    ss.add(nums[bit]);
                }
            }
            resSet.add(ss);
        }
        return new ArrayList<>(resSet);
    }
}