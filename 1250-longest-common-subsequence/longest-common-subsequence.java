class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[] prev = new int[l2+1];
        int[] curr = new int[l2+1];
        for(int i = 1; i<=l1; i++){
            for(int j = 1; j<=l2; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    curr[j] = 1+prev[j-1];
                }else{
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            prev = curr;
            curr = new int[l2+1];
        }
        return prev[l2];
    }
}