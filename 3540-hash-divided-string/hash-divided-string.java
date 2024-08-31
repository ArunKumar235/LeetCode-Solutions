class Solution {
    public String stringHash(String s, int k) {
        String st = "";
        int l = s.length();
        for(int i = 0; i<l; i+=k){
            st += func(s.substring(i,i+k));
        }    
        return st;
    }
    public char func(String s){
        int co = 0;
        for(char c: s.toCharArray()){
            co+=c-'a';
        }
        return (char)(co%26 + 'a');
    }

}