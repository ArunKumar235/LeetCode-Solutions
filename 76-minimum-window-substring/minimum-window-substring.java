class Solution {
    public String minWindow(String s, String t) {
        if(s.isEmpty() || t.isEmpty() || s.length()<t.length()) return "";

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<t.length(); i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i), 0)+1);
        }
        int count = map.size();
        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minLength = Integer.MAX_VALUE;

        while(right<s.length()){
            char toAdd = s.charAt(right);
            if(map.containsKey(toAdd)) map.replace(toAdd, map.get(toAdd)-1);
            if(map.getOrDefault(toAdd, 1)==0) count--;
            while(count==0){
                if(right-left+1 < minLength){
                    minLength = right-left+1;
                    minLeft = left;
                }
                char toRemove = s.charAt(left);
                if(map.containsKey(toRemove)){
                    map.replace(toRemove, map.get(toRemove)+1);
                    if(map.get(toRemove)==1) count++;
                }
                left++;
            }
            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft+minLength);
    }
}