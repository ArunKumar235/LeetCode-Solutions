// O(N)
class Solution {
    int idx = 0; // shared idx pointer to avoid re-evaluating sub problems
    String s;
    public boolean parseBoolExpr(String s) {
        this.s = s;
        return func();
    }

    private boolean func(){
        char c = s.charAt(idx);
        if(c == 't'){ 
            idx++; // skip t
            return true;
        }
        if(c == 'f'){
            idx++; // skip f
            return false;
        }
        
        idx += 2; // skip operator and (

        if(c == '!'){
            boolean res = !func();
            idx++; // skip )
            return res;
        }

        int trueCount = 0;
        int falseCount = 0;

        while(s.charAt(idx) != ')'){
            if(s.charAt(idx) == ','){
                idx++;
            }else{
                if(func()) trueCount++; 
                else falseCount++;
            }
        }

        idx++; // skip )

        if(c == '&') return falseCount == 0;
        if(c == '|') return trueCount > 0;

        return true; // dummy
    }
}