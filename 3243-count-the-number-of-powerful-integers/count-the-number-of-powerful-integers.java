class Solution {
    int maxDigit;
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        this.maxDigit = limit;
        return count(finish, s) - count(start-1, s);
    }

    private long count(long num, String s){
        String str = String.valueOf(num);
        int len = str.length();

        if(s.length() > len) return 0;

        // idx - tight
        long[][] dp = new long[len][2];

        for(int i = 0; i<len; i++){
            Arrays.fill(dp[i], -1);
        }
        return func(str, 0, 0, dp, s);
    }

    private long func(String str, int idx, int tight, long[][] dp, String s){
        if(idx == str.length()) return 1;

        if(dp[idx][tight] != -1) return dp[idx][tight];
        
        // 0 1 2 3 4 5 6
        //         4 5 6
        int suffixStartIdx = str.length() - s.length();
        
        long ans = 0;

        int limit = (tight == 1) ? 9 : str.charAt(idx) - '0';
        int bound = Math.min(limit, maxDigit);

        for(int d = 0; d <= bound; d++){
            if(idx >= suffixStartIdx && d != (s.charAt(idx - suffixStartIdx) - '0')) continue;

            int newTight = (tight == 0 && d == limit) ? 0 : 1;

            ans += func(str, idx+1, newTight, dp, s);
        }
        return dp[idx][tight] = ans;
    }
}