class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target, new ArrayList<Integer>());
        return ans;
    }
    public void backtrack(int[] arr,int index, int target, List<Integer> li){
        if(target < 0 || index >= arr.length) return;
        if(target==0) {
            ans.add(new ArrayList<>(li));
            return;
        }
        li.add(arr[index]);
        backtrack(arr,index, target-arr[index], li);
        li.remove(li.size()-1);
        backtrack(arr, index+1, target, li);
    }
}