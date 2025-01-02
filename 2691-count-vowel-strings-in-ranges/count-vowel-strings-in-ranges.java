class Solution {
    public boolean isVowel(char s) {
        return s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u';
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int m = words.length;
        int[] prefixsum = new int[m];
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            String word = words[i];
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                cnt++;
            }
            prefixsum[i] = cnt;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0] - 1;
            int r = queries[i][1];

            if (l < 0) {
                ans[i] = prefixsum[r];
            } else {
                ans[i] = prefixsum[r] - prefixsum[l];
            }
        }
        return ans;
    }
}