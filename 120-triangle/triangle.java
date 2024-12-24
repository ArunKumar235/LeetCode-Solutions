class Solution {
    public int minimumTotal(List<List<Integer>> tri) {
        int r = tri.size();
        int[] prev = new int[1];
        for(int i = 0; i<r; i++){
            int[] curr = new int[i+1];
            for(int j = 0; j<=i; j++){
                curr[j] += tri.get(i).get(j);
                if(i>0 && j>0){
                    if(i==j){
                        curr[j] += prev[j-1];
                    }else{
                        curr[j] += Math.min(prev[j], prev[j-1]);
                    }
                }
                else if(i>0) curr[j] += prev[0];
            }
            prev = curr;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i<r; i++){
            res = Math.min(res, prev[i]);
        }
        return res;
    }
}