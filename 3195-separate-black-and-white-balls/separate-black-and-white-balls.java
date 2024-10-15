class Solution {
    public long minimumSteps(String s) {
        int white = 0;
        long res = 0;
        int n = s.length();
        for (int j = 0; j < n; ++j) {
            if (s.charAt(j) == '0') {
                res += white;
            } else if (s.charAt(j) == '1') {
                white++;
            }
        }
        return res;
    }
}