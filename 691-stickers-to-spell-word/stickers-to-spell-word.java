class Solution {
    public int minStickers(String[] stickers, String target) {
        int n = target.length();
        int maxMask = 1 << n;
        
        // dp[mask] = minimum number of stickers needed to form given state mask
        int[] dp = new int[maxMask];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int mask = 0; mask < maxMask; mask++){
            if(dp[mask] == Integer.MAX_VALUE) continue;

            // try applying each sticker to current mask state
            for(String sticker : stickers){
                int superMask = mask;
                
                for(char c : sticker.toCharArray()){
                    for(int i = 0; i < n; i++){
                        // if target character matches and isn't already set in superMask
                        if(c == target.charAt(i) && (superMask & (1 << i)) == 0){
                            superMask |= (1 << i);
                            break; // each character in sticker can cover at most one target character
                        }
                    }
                }
                // update transition with minimum stickers needed
                dp[superMask] = Math.min(dp[superMask], dp[mask] + 1);
            }
        }
        return dp[maxMask - 1] == Integer.MAX_VALUE ? -1 : dp[maxMask - 1];
    }
}