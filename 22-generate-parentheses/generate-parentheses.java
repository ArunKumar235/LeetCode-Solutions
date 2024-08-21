class Solution {
    int n;
    List<String> rec = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        this.n = n;
        generator(0,0,"");
        return rec;
    }

    public void generator(int left, int right, String res){
        if(res.length() == n+n){
            rec.add(res);
            return;
        }
        if(left<n){
            generator(left+1, right, res+"(");
        }if(right<left){
            generator(left, right+1, res+")");
        }

    }
}