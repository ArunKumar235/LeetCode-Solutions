class Solution {
    int k;
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        this.k = k;
        return count(high, k) - count(low-1, k);
    }

    private int count(int num, int k){
        String str = String.valueOf(num);
        int len = str.length();

        // idx - tight - begin - rem - diff
        int[][][][][] dp = new int[len][2][2][k][2*len +1];

        for(int i = 0; i<len; i++){
            for(int j = 0; j<2; j++){
                for(int a = 0; a<2; a++){
                    for(int b = 0; b<k; b++){
                        Arrays.fill(dp[i][j][a][b], -1);
                    }
                }
            }
        }

        return func(str, 0, 0, 0, 0, 0, dp);
    }

    // tight - 0 - prev digits are equal 
    // tight - 1 - smaller digit occured

    // begin - 0 - prev digits are only 0
    // begin - 1 - non 0 digit occured

    // rem - reminder until now

    // diff - even +, odd -, dp table stores diff+len

    private int func(String str, int idx, int tight, int  begin, int rem, int diff, int[][][][][] dp){
        if(idx == str.length()){
            return (begin == 1 && diff == 0 && rem == 0) ? 1 : 0;
        }

        if(dp[idx][tight][begin][rem][diff + str.length()] != -1){
            return dp[idx][tight][begin][rem][diff + str.length()];
        }

        int limit = (tight == 1) ? 9 : str.charAt(idx) - '0';

        int ans = 0;

        for(int d = 0; d<=limit; d++){
            int newTight = (tight == 0 && d == limit) ? 0 : 1;
            int newRem = (rem * 10 + d) % k;

            if(begin == 0 && d == 0){
                ans += func(str, idx+1, newTight, 0, 0, 0, dp);
            }else{
                int newDiff = diff;
                if(d % 2 == 0) newDiff++;
                else newDiff--;

                ans += func(str, idx+1, newTight, 1, newRem, newDiff, dp);
            }
        }
        return dp[idx][tight][begin][rem][diff + str.length()] = ans;
    }
}