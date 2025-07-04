class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s.length() == 0 || words.length == 0) return list;

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        int len = s.length();

        if (totalLen > len) return list;

        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int count = 0;
            Map<String, Integer> windowFreq = new HashMap<>();

            for (int right = i; right <= len - wordLen; right += wordLen) {
                String currentWord = s.substring(right, right + wordLen);

                if (freq.containsKey(currentWord)) {
                    windowFreq.put(currentWord, windowFreq.getOrDefault(currentWord, 0) + 1);
                    count++;

                    // If current word count exceeds required, move left pointer
                    while (windowFreq.get(currentWord) > freq.get(currentWord)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowFreq.put(leftWord, windowFreq.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // If we found a valid substring
                    if (count == words.length) {
                        list.add(left);
                        // Move left pointer by one word to continue searching
                        String leftWord = s.substring(left, left + wordLen);
                        windowFreq.put(leftWord, windowFreq.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                } else {
                    // Current word not in words array, reset window
                    windowFreq.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }
        return list;
    }
}