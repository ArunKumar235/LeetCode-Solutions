class Solution {
    public int compress(char[] chars) {
        int resIdx = 0;
        int L = chars.length;
        int pos = 0;
        while(pos<L){
            int len = 0;
            char ch = chars[pos];
            while(pos+len<L && ch==chars[pos+len]){
                len++;
            }
            chars[resIdx++] = ch;
            pos+=len;
            if(len==1) continue;
            for(char c: String.valueOf(len).toCharArray()){
                chars[resIdx++] = c;
            }
        }
        return resIdx;
    }
}