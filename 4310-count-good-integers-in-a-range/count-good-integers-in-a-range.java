class Solution {
    public long goodIntegers(long l, long r, int k) {
        return count(r, k) - count(l-1, k);
    }

    private long count(long num, long k){
        String str = String.valueOf(num);
        int len = str.length();
        long[][][][] dp = new long[len][2][2][11];
        for(int i = 0; i<len; i++){
            for(int j = 0; j<2; j++){
                for(int r = 0; r<2; r++) Arrays.fill(dp[i][j][r], -1);
            }
        }
        return func(str, 0, 1, 1, 10, k, dp);
    }
    // tight - 0 - prev values is changed
    // tight - 1 - prev values not changed, so limit to be followed

    // begin - 1 - leading digits only 0's 
    // begin - 0 - number formation started
    private long func(String str, int idx, int tight, int begin, int prev, long k, long[][][][] dp){
        if(idx == str.length()){
            return begin == 1 ? 0 : 1;
        }

        if(dp[idx][tight][begin][prev] != -1) return dp[idx][tight][begin][prev];

        long ans = 0;

        int limit = tight == 0 ? 9 : str.charAt(idx) - '0';

        for(int d = 0; d<=limit; d++){
            int newTight = (tight == 1 && d == limit) ? 1 : 0;

            if(begin == 1 && d == 0){
                ans += func(str, idx+1, newTight, 1, 10, k, dp);
            }else{
                if(prev == 10 || Math.abs(prev-d) <= k){
                    ans += func(str, idx+1, newTight, 0, d, k, dp);
                }
            }
        } 
        dp[idx][tight][begin][prev] = ans;
        return ans;
    }
}