class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] inc = new int[n];
        
        inc[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            inc[i] = nums.get(i) < nums.get(i + 1) ? inc[i + 1] + 1 : 1;
        }
        int maxK = 0;
        int max = 0;
        for(int i = 0; i<n; i++){
            int val = inc[i];
            max = Math.max(max, val);
            if(i+val < n && inc[i+val]>=inc[i]) maxK = Math.max(maxK, inc[i]);
        }
        return Math.max(max/2, maxK);
    }
}