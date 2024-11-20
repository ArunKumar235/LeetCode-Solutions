class Solution {
    public int takeCharacters(String s, int k) {
        int[] totalCount = new int[3];
        int[] windowCount = new int[3];
        
        for (char c : s.toCharArray()) {
            totalCount[c - 'a']++;
        }
        for (int i = 0; i < 3; i++) {
            if (totalCount[i] < k) return -1;
        }

        int maxLength = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            windowCount[s.charAt(right) - 'a']++;

            while (left <= right && 
                windowCount[s.charAt(right) - 'a'] > totalCount[s.charAt(right) - 'a']-k) {
                
                windowCount[s.charAt(left) - 'a']--;
                left++;
            
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return s.length() - maxLength;
    }
}
