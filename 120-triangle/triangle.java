class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        int r = tri.size();
        int[] prev = new int[r];
        for(int i = 0; i<r; i++){
            prev[i] = tri.get(r-1).get(i);
        }

        for(int i = r-2; i>=0; i--){
            int[] curr = new int[i+1];
            for(int j = i; j>=0; j--){
                curr[j] += tri.get(i).get(j);
                curr[j] += Math.min(prev[j], prev[j+1]);
            }
            prev = curr;
        }
        
        return prev[0];
    }
}