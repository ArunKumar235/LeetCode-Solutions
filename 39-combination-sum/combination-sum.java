class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(0, 0, candidates.length, candidates, target, curr, res);

        return res;
    }

    private void backtrack(int sum, int i, int n, int[] arr, int t, List<Integer> curr, List<List<Integer>> res){
        if(sum==t){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(i==n || sum>t) return;

        backtrack(sum, i+1, n, arr, t, curr, res);

        curr.add(arr[i]);
        backtrack(sum+arr[i], i, n, arr, t, curr, res);
        curr.remove(curr.size()-1);
    }
}