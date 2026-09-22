class Solution {
    int INF = Integer.MAX_VALUE;
    
    String[] stickers;
    int[][] count;

    String target;
    int n;
    int[] dp;
    
    public int minStickers(String[] stickers,String target) {
        n = target.length();
        this.target = target;
        
        // count[i] = char freq array for stickers[i]
        count = new int[stickers.length][26];

        for(int i = 0; i < stickers.length; i++) {
            for(char c : stickers[i].toCharArray()) {
                count[i][c - 'a']++;
            }
        }

        dp = new int[1 << n];
        Arrays.fill(dp, -1);

        int res = func(0);

        return res == INF ? -1 : res;
    }
    
    // Memoization - I've already solved this state, so don't solve it again.
    // Pruning - This choice isn't worth exploring in the first place.
    // we are immediately rejecting the sticker that won't be useful at the moment, 
    // instead of exploring all stickers
    // if the first char doesn't match, we are temporarily rejecting the sticker for current state, 
    // we might still use it in future

    private int func(int state){
        if(state == (1 << n) - 1) return 0;

        if(dp[state] != -1) return dp[state];

        // find the first unset character
        int idx = 0;
        while((state & (1 << idx)) != 0) {
            idx++;
        }

        int res = INF;

        int targetChar = target.charAt(idx) - 'a';

        for(int s = 0; s < count.length; s++) {
            if(count[s][targetChar] == 0) continue;

            int newState = state;
            int[] stickerFreq = count[s].clone();
            // apply the sticker
            for(int t = idx; t < n; t++) {
                if((newState & (1 << t)) != 0) continue;

                int c = target.charAt(t) - 'a';

                if(stickerFreq[c] > 0) {
                    newState |= (1 << t);
                    stickerFreq[c]--;
                }
            }

            if(newState != state) {
                int next = func(newState);

                if(next != INF) res = Math.min(res, next + 1);
            }
        }
        return dp[state] = res;
    }
}