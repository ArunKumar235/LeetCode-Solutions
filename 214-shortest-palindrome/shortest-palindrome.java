class Solution {
    public String shortestPalindrome(String s) {
        return helper(s);
    }

    public String helper(String s) {
        int left = 0;
        int right = s.length() - 1;
        // Finding longest common palindromic subsequence, 
        // among the string and reverse of that string
        // aacecaaa
        // aaacecaa => aacecaa | a => a | aacecaa | a
        while (left < s.length() && right >= 0) {
            while (right >= 0 && s.charAt(left) != s.charAt(right)) {
                right--;
            }
            left++;
            right--;
        }
        if (left == s.length()) {
            return s;
        } else {
            String sub = s.substring(left);
            return new StringBuilder(sub).reverse().toString() + helper(s.substring(0, left)) + sub;
        }
    }
}