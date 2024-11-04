class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int L = word.length();
        int pos = 0;
        while(pos<L){
            int len = 0;
            char ch = word.charAt(pos);
            while(pos+len<L && ch==word.charAt(pos+len)){
                len++;
                if(len==9){
                    break;
                }
            }
            sb.append(len).append(ch);
            pos+=len;
        }
        return sb.toString();
    }
}