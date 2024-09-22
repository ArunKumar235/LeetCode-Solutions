class Solution {
    public long validSubstringCount(String w1, String w2) {
        int n1 = w1.length();
        int n2 = w2.length();

        if (n1 < n2) {
            return 0;
        }

        int[] req = new int[26];
        for (char c : w2.toCharArray()) {
            req[c - 'a']++;
        }

        long total = 0;
        int[] cur = new int[26];
        int left = 0;
        int valid = 0;

        for (int right = 0; right < n1; right++) {
            char rc = w1.charAt(right);
            cur[rc - 'a']++;

            if (cur[rc - 'a'] <= req[rc - 'a']) {
                valid++;
            }

            while (valid >= n2) {
                total += (n1 - right);
                char lc = w1.charAt(left);
                cur[lc - 'a']--;

                if (cur[lc - 'a'] < req[lc - 'a']) {
                    valid--;
                }
                left++;
            }
        }

        return total;
    }
}
