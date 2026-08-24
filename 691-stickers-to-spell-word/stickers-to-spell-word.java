class Solution {
    int INF = Integer.MAX_VALUE;

    public int minStickers(String[] stickers,String target) {
        int n = target.length();

        // count[i] = char freq array for stickers[i]
        int[][] count = new int[stickers.length][26];

        for(int i = 0; i < stickers.length; i++) {
            for(char c : stickers[i].toCharArray()) {
                count[i][c - 'a']++;
            }
        }

        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);

        int res = func(0,count,target,n,dp);

        return res == INF ? -1 : res;
    }
    
    // Memoization - I've already solved this state, so don't solve it again.
    // Pruning - This choice isn't worth exploring in the first place.
    // we are immediately rejecting the sticker that won't be useful at the moment, 
    // instead of exploring all stickers
    // if the first char doesn't match, we are temporarily rejecting the sticker for current state, 
    // we might still use it in future

    private int func(int state,int[][] count,String target,int n,int[] dp) {
        if(state == (1 << n) - 1) return 0;

        if(dp[state] != -1) return dp[state];

        int res = INF;

        int first = -1;

        for(int i = 0; i < n; i++){
            if((state & (1 << i)) == 0){
                first = i;
                break;
            }
        }

        int targetChar = target.charAt(first) - 'a';

        for(int s = 0; s < count.length; s++) {
            if(count[s][targetChar] == 0) continue;

            int newState = state;
            int[] stickerFreq = count[s].clone();

            for(int t = 0; t < n; t++) {
                if((newState & (1 << t)) != 0) continue;

                int c = target.charAt(t) - 'a';

                if(stickerFreq[c] > 0) {
                    newState |= (1 << t);
                    stickerFreq[c]--;
                }
            }

            if(newState != state) {
                int next = func(newState,count,target,n,dp);

                if(next != INF) res = Math.min(res,next + 1);
            }
        }
        return dp[state] = res;
    }
}
