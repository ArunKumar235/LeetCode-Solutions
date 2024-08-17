class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    
    public int rob(int[] arr) {
        return soln(0, arr);
    }

    public int soln(int i, int[] arr){
        if(i>=arr.length) return 0;
        if(memo.containsKey(i)) return memo.get(i);

        int crob = arr[i] + soln(i+2, arr);
        int nrob = soln(i+1, arr);
        int result = Math.max(crob, nrob);
        memo.put(i, result);
        return result;
    }
}