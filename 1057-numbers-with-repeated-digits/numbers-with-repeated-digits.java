class Solution {
    public int numDupDigitsAtMostN(int n) {
        return count(n);
    }

    private int count(int num){
        String str = String.valueOf(num);
        int len = str.length();

        int bitMask = (1 << 10) - 1;

        // idx - tight - begin - bitMask - repeat
        int[][][][][] dp = new int[len][2][2][bitMask + 1][2];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < 2; j++){
                for(int k = 0; k < 2; k++){
                    for(int mask = 0; mask <= bitMask; mask++){
                        Arrays.fill(dp[i][j][k][mask], -1);
                    }
                }
            }
        }

        return func(str, 0, 0, 0, bitMask, dp, 0);
    }

    // tight - 0 - previous digits are equal
    // tight - 1 - smaller digit occurred

    // begin - 0 - number has not started
    // begin - 1 - number has started

    // bitMask:
    // bit = 1 -> digit has not appeared
    // bit = 0 -> digit has already appeared

    private int func(String str, int idx, int tight, int begin,
                     int bitMask, int[][][][][] dp, int repeat){

        if(idx == str.length()){
            return repeat;
        }

        if(dp[idx][tight][begin][bitMask][repeat] != -1){
            return dp[idx][tight][begin][bitMask][repeat];
        }

        int ans = 0;

        int limit = tight == 1 ? 9 : str.charAt(idx) - '0';

        for(int d = 0; d <= limit; d++){
            int newTight = (tight == 0 && d == limit) ? 0 : 1;

            if(begin == 0 && d == 0){
                ans += func(str, idx + 1, newTight, 0, bitMask, dp, repeat);
            }else{
                int newBitMask = bitMask;
                int newRepeat = repeat;

                if((bitMask & (1 << d)) == 0){
                    newRepeat = 1;
                }else{
                    newBitMask = bitMask ^ (1 << d);
                }

                ans += func(str, idx+1, newTight, 1, newBitMask, dp, newRepeat);
            }
        }
        return dp[idx][tight][begin][bitMask][repeat] = ans;
    }
}