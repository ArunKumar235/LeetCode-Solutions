class Solution {
    public int maxScore(String s) {
        int maxScore = 0;
        int leftZeros = 0;
        int rightOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                rightOnes++;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }
            maxScore = Math.max(maxScore, leftZeros + rightOnes);
        }

        return maxScore;
    }
}