// Choose smallest window
//         ↓
// remove its counts from total
//         ↓
// everything remaining must have count <= n/4
class Solution {
    public int balancedString(String s) {
        int n = s.length();
        // used to represent count of characters outise the window
        int[] count = new int[128];
        
        for(int i = 0; i < n; i++) count[s.charAt(i)]++;

        int l = 0;
        int res = n;
        int k = n/4;

        for(int r = 0; r < n; r++){
            // r goes inside the window, so count is reduced
            count[s.charAt(r)]--;
            
            // shrink window when outside is valid
            // when outside freq is <= k, we could modify inside to any characters of our wish
            
            // https://leetcode.com/problems/replace-the-substring-for-balanced-string/solutions/408978/javacpython-sliding-window/comments/1101250/
            while(l < n && count['Q'] <= k && count['W'] <= k && count['E'] <= k && count['R'] <= k){
                res = Math.min(res, r - l + 1);
                
                // l goes outside the window, so count is increased
                count[s.charAt(l++)]++;
            }
        }
        return res;
    }
}