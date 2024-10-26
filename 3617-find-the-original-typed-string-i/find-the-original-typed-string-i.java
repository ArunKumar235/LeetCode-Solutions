class Solution {
    public int possibleStringCount(String word) {
        int start = 0;
        int end = 0;
        int res = 0;
        while(end<word.length()){
            while(end+1<word.length() && word.charAt(end+1)==word.charAt(start)){
                end++;
            }
            res += end-start;
            start = ++end;
        }
        return res+1;
    }
}