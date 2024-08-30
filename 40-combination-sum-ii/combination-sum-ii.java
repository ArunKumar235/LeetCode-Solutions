class Solution {

    List < List < Integer >> ans = new ArrayList < > ();
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, new ArrayList < > ());
        return ans;
    }
    public void findCombinations(int ind, int[] arr, int target, List < Integer > ds) {
        if (target == 0) {
            ans.add(new ArrayList < > (ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ds);
            ds.remove(ds.size() - 1);
        }
    }
}