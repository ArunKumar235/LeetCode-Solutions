class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int count = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)==')'){
                if(i+1<s.length() && s.charAt(i+1)==')'){
                    if(open!=0) open--;
                    else count++;
                    i++;
                }else{
                    if(open!=0){
                        count++;
                        open--;
                    }else{
                        count+=2;
                    }
                }
            }else{
                open++;
            }
        }
        return open*2 + count;
    }
}