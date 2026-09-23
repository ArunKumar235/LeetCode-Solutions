class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int W = words.length;

        int[] freq = new int[26];
        for(char ch: letters){
            freq[ch - 'a']++;
        }

        int maxScore = 0;

        for(int state = 1; state < (1<<W); state++){
            int currScore = 0;
            int[] currFreq = freq.clone();

            for(int i = 0; i < W; i++){
                if((state & (1<<i)) != 0){
                    int wordScore = addScore(words[i], currFreq, score); 

                    if(wordScore == -1){
                        currScore = 0;
                        break;
                    }else{
                        currScore += wordScore;
                    }
                }
            }
            maxScore = Math.max(maxScore, currScore);
        }
        return maxScore;
    }

    private int addScore(String word, int[] freq, int[] score){
        int currScore = 0;
        
        for(char ch: word.toCharArray()){
            freq[ch-'a']--;
            currScore += score[ch-'a'];

            if(freq[ch-'a'] < 0) return 0;
        }

        return currScore;
    }
}