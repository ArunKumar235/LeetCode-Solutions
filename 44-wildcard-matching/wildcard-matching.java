class Solution {
    public boolean isMatch(String s, String p) {
        int l1 = s.length();
        int l2 = p.length();

        boolean[] prev = new boolean[l2+1];
        boolean[] curr = new boolean[l2+1];

        prev[0] = true;

        for(int j = 1; j<=l2; j++) if(p.charAt(j-1)=='*') prev[j] = prev[j-1];

        for(int i = 1; i<=l1; i++){
            for(int j = 1; j<=l2; j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?') curr[j] = prev[j-1];

                else if(p.charAt(j-1)=='*') curr[j] = prev[j] || curr[j-1];

                else curr[j] = false;
            }
            prev = curr.clone();
        }
        return prev[l2];
    }
}