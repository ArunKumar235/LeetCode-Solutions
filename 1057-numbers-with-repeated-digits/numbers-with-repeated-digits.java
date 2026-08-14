class Solution {
    public int numDupDigitsAtMostN(int n) {
        return n - countUnique(n);
    }

    private int countUnique(int num){
        String str = String.valueOf(num);
        int len = str.length();
        
        // idx - tight - begin - bitMask (1024 - 10000000000)
        int[][][][] dp = new int[len][2][2][1 << 10];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 2; k++){
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }
        return func(str, 0, 0, 0, 0, dp);
    }

    // tight - 0 - previous digits equal to n
    // tight - 1 - already smaller than n

    // begin - 0 - number has not started
    // begin - 1 - number has started

    // mask:
    // bit - 0 - digit unused
    // bit - 1 - digit already used

    private int func(String str, int idx, int tight, int begin, int mask, int[][][][] dp){

        if(idx == str.length()){
            return begin == 1 ? 1 : 0;
        }

        if(dp[idx][tight][begin][mask] != -1) return dp[idx][tight][begin][mask];

        int limit = (tight == 1) ? 9 : str.charAt(idx) - '0';

        int ans = 0;

        for(int d = 0; d <= limit; d++){
            int newTight = (tight == 0 && d == limit) ? 0 : 1;

            if(begin == 0 && d == 0){
                ans += func(str, idx+1, newTight, 0, mask, dp);
                continue;
            }

            if((mask & (1 << d)) != 0){ // digit occured already, so not unique
                continue;
            }

            int newMask = mask | (1 << d);

            ans += func(str, idx+1, newTight, 1, newMask, dp);
        }
        return dp[idx][tight][begin][mask] = ans;
    }
}