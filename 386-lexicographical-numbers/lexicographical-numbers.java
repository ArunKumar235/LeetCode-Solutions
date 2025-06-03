class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i<=9; i++){
            dfs(i, n, res);
        }
        return res;
    }

    private void dfs(int i, int limit, List<Integer> res){
        if(i>limit) return;
        res.add(i);
        for(int j = 0; j<=9; j++){
            int next = i*10 + j;
            if(next<=limit){
                dfs(next, limit, res);
            }else{
                break;
            }
        }
    }
}