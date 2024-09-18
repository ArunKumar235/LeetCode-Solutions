class Solution {
    
    public int maxPossibleScore(int[] start, int d) {

        Arrays.sort(start);
        int n = start.length;
        int low = 0;
        // int high = start[n-1] + d - start[0];
        int high = Integer.MAX_VALUE;
            
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(start, d, mid)) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return ans;

        
    }

    public boolean isPossible(int[] start, int d, int diff) {

            int curr = start[0];

            for (int i = 1; i < start.length; i++) {
                if ( (curr+diff) > start[i] + d) {
                    return false;
                }

            curr = Math.max(start[i], curr + diff);

            }

            return true;
    }
   
}