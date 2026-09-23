class Solution {
    int res = 0;
    String[] words;
    int[] freq;
    int[] score;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.words = words;
        this.score = score;
        this.freq = new int[26];
        for(char ch: letters){
            freq[ch - 'a']++;
        }

        backtrack(0, 0);

        return res;
    }

    private void backtrack(int idx, int currScore){
        if(idx == words.length){
            res = Math.max(res, currScore);
            return;
        }

        boolean isPossible = true;

        for(char ch: words[idx].toCharArray()){
            freq[ch-'a']--;
            currScore += score[ch-'a'];

            if(freq[ch-'a'] < 0) isPossible = false;
        }

        if(isPossible){
           backtrack(idx + 1, currScore); 
        }

        for(char ch: words[idx].toCharArray()){
            freq[ch-'a']++;
            currScore -= score[ch-'a'];
        }

        backtrack(idx+1, currScore); 
    }
}