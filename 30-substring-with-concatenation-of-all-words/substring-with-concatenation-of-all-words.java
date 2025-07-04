import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        
        int wordLen = words[0].length();
        int totalWords = words.length;
        int substringLen = wordLen * totalWords;
        int n = s.length();
        
        if (substringLen > n) {
            return res;
        }
        
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int count = 0;
            Map<String, Integer> windowFreq = new HashMap<>();
            
            for (int right = i; right <= n - wordLen; right += wordLen) {
                String currentWord = s.substring(right, right + wordLen);
                
                if (freq.containsKey(currentWord)) {
                    windowFreq.put(currentWord, windowFreq.getOrDefault(currentWord, 0) + 1);
                    count++;
                    
                    while (windowFreq.get(currentWord) > freq.get(currentWord)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowFreq.put(leftWord, windowFreq.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                    
                    if (count == totalWords) {
                        res.add(left);
                        String leftWord = s.substring(left, left + wordLen);
                        windowFreq.put(leftWord, windowFreq.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                } else {
                    windowFreq.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }
        
        return res;
    }
}