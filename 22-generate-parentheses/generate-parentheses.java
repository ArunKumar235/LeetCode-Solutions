class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        rec(0, 0, n, res, "");

        return res;
    }

    private void rec(int open, int close, int n, List<String> res, String str){
        if(open==n && close==n){
            res.add(str);
            return;
        }

        if(open<n){
            rec(open+1, close, n, res, str+"(" );
        }
        if(close<open){
            rec(open,close+1, n, res, str+")");
        }
    }
}