class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() -b.length());
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<i; j++){
                if(isPredecessor(words[j], words[i]) && dp[j]+1 > dp[i] ){
                    dp[i] = 1 + dp[j];
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    private boolean isPredecessor(String a, String b){
        if(a.length()+1 != b.length()) return false;
        int i = 0;
        int j = 0;
        while(j<b.length()){
            if(i<a.length() && a.charAt(i)==b.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        return i==a.length() && j==b.length();
    }
}