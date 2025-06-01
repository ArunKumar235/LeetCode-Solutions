class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for (String query : queries) {
            result.add(isMatch(query, pattern));
        }
        return result;
    }
    
    private boolean isMatch(String query, String pattern) {
        int i = 0;
        int j = 0;
        
        while (i < query.length() && j < pattern.length()) {
            char qc = query.charAt(i);
            char pc = pattern.charAt(j);
            
            if (qc == pc) {
                i++;
                j++;
            } else {
                if (Character.isUpperCase(qc)) {
                    return false;
                }
                i++;
            }
        }
        
        if (j < pattern.length()) {
            return false;
        }
        
        while (i < query.length()) {
            if (Character.isUpperCase(query.charAt(i))) {
                return false;
            }
            i++;
        }
        
        return true;
    }
}