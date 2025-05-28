class Solution {
    public String minimumString(String a, String b, String c) {
        String[] permutations = {
            merge(merge(a, b), c),
            merge(merge(a, c), b),
            merge(merge(b, a), c),
            merge(merge(b, c), a),
            merge(merge(c, a), b),
            merge(merge(c, b), a)
        };

        String result = permutations[0];
        for (String s : permutations) {
            if (s.length() < result.length() || 
                (s.length() == result.length() && s.compareTo(result) < 0)) {
                result = s;
            }
        }
        
        return result;
    }

    private String merge(String a, String b) {
        if(a.contains(b)) return a;
        if(b.contains(a)) return b;
        
        int maxOverlap = Math.min(a.length(), b.length());
        for(int i = maxOverlap; i >= 0; i--){
            if(a.endsWith(b.substring(0, i))){
                return a + b.substring(i);
            }
        }
        return a + b;
    }
}