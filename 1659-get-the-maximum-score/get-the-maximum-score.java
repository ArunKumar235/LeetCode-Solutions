class Solution {
    final int mod = 1000000007;
    public int maxSum(int[] nums1, int[] nums2) {
        int i = 0, j = 0, n = nums1.length, m = nums2.length;
        long sum1 = 0, sum2 = 0, res = 0;

        while(i<n && j<m){
            if(nums1[i] < nums2[j]){
                sum1 += nums1[i++];
            }else if(nums1[i] > nums2[j]){
                sum2 += nums2[j++];
            }else{
                // Merge paths at common element
                res = (res + Math.max(sum1, sum2) + nums1[i]) % mod;
                sum1 = sum2 = 0;
                i++;
                j++;
            }
        }
        while(i < n) sum1 += nums1[i++];
        while(j < m) sum2 += nums2[j++];

        res = (res + Math.max(sum1, sum2)) % mod;

        return (int)res;
    }
}