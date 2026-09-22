class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums); // Sort to handle duplicates easily
        
        backtrack(0, nums, new ArrayList<>());

        return res;
    }
    
    private void backtrack(int idx, int[] nums, List<Integer> temp){
        res.add(new ArrayList<>(temp));

        for(int i = idx; i < nums.length; i++){
            // Skip duplicates at the same recursive level
            if(i > idx && nums[i] == nums[i-1]) continue; 

            temp.add(nums[i]);
            backtrack(i+1, nums, temp);
            temp.remove(temp.size() - 1);
        }
    }
}