class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        func(s, 0, new ArrayList<>());
        return res;
    }

    private void func(String s, int l, List<String> li){
        if(l == s.length()){
            res.add(List.copyOf(li));
            return;
        }

        for(int k = l; k < s.length(); k++){
            if(isPal(s, l, k)){
                li.add(s.substring(l, k+1));
                
                func(s, k+1, li);
                
                li.remove(li.size() - 1);
            }
        }
        return;
    }

    private boolean isPal(String s, int l, int r){
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}