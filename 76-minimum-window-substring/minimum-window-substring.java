class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int count = map.size();
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()) {
            char toAdd = s.charAt(right);
            if (map.containsKey(toAdd)) {
                map.put(toAdd, map.get(toAdd) - 1);
                if (map.get(toAdd) == 0) {
                    count--;
                }
            }
            
            while (count == 0) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }
                
                char toRemove = s.charAt(left);
                if (map.containsKey(toRemove)) {
                    map.put(toRemove, map.get(toRemove) + 1);
                    if (map.get(toRemove) > 0) {
                        count++;
                    }
                }
                left++;
            }
            
            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}
