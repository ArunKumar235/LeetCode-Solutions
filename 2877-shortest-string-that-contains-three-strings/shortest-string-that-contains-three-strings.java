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

        Arrays.sort(permutations, (x,y) -> x.length()!=y.length() ? x.length()-y.length() : x.compareTo(y));

        return permutations[0];
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