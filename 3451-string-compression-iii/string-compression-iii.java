class Solution {
    public String compressedString(String word) {
        if(word.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        int len = 1;
        char prev = word.charAt(0);
        for(int i = 1; i<word.length(); i++){
            if(word.charAt(i)==prev){
                if(len==9){
                    sb.append(len).append(prev);
                    len = 1;
                }else{
                    len++;
                }
            }else{
                sb.append(len).append(prev);
                len = 1;
                prev = word.charAt(i);
            }
        }
        sb.append(len).append(prev);
        return sb.toString();
    }
}