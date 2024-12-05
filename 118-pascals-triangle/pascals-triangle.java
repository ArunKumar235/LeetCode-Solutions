class Solution {
    public List<List<Integer>> generate(int row) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 1 ; i<=row; i++){
            List<Integer> li = new ArrayList<>();
            for(int j = 0; j<i; j++){
                if(j==0 || j==i-1){
                    li.add(1);
                }else{
                    li.add(res.get(i-2).get(j-1)+res.get(i-2).get(j));
                }
            }
            res.add(li);
        }
        return res;
    }
}