class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder("");
        int L = chars.length;
        int pos = 0;
        while(pos<L){
            int len = 0;
            char ch = chars[pos];
            while(pos+len<L && ch==chars[pos+len]){
                len++;
            }
            sb.append(ch);
            if(len!=1) sb.append(len);
            pos+=len;
        }
        for(int i = 0; i<sb.length(); i++){
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
}