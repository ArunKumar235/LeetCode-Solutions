class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        int[][][] memo = new int[s1.length()][s2.length()][s3.length()];
        return rec(0,0,0,s1,s2,s3, memo);    
    }

    private boolean rec(int i, int j, int k, String s1, String s2, String s3, int[][][] memo){
        if(k==s3.length()) return true;
        if(i==s1.length()) return s2.substring(j).equals(s3.substring(k));
        if(j==s2.length()) return s1.substring(i).equals(s3.substring(k));

        if(memo[i][j][k]!= 0) return (memo[i][j][k]==1) ? true : false;

        if(s1.charAt(i)==s3.charAt(k) && s2.charAt(j)==s3.charAt(k)) {
            if(rec(i+1, j, k+1, s1, s2, s3, memo) || rec(i, j+1, k+1, s1, s2, s3, memo)){
                memo[i][j][k] = 1;
                return true;
            }
        }
        if(s1.charAt(i)==s3.charAt(k)){
            if(rec(i+1, j, k+1, s1, s2, s3, memo)){
                memo[i][j][k] = 1;
                return true;
            }
        }
        if(s2.charAt(j)==s3.charAt(k)) {
            if(rec(i, j+1, k+1, s1, s2, s3, memo)){
                memo[i][j][k] = 1;
                return true;
            }
        }
        memo[i][j][k] = -1;
        return false;
    }
}