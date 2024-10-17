class Solution {
    public int minInsertions(String s) {
        int count=0;
        int open=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==')'){
                if(i+1<s.length() && s.charAt(i+1)==')'){
                    if(open!=0)open--;
                    else count++;
                    i++;
                }else{
                    if(open!=0){
                        count++;
                        open--;
                    }else count+=2;
                }
            }else open++;
            
        }
        return open*2+count;
    }
}