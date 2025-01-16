class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        int l = 0;
        int r = n-1;
        int lmax = height[0];
        int rmax = height[n-1];

        int res = 0;

        while(l<r){
            if(lmax<=rmax){
                res += lmax - height[l];
                l++;
                lmax = Math.max(lmax, height[l]);
            }else{
                res += rmax - height[r];
                r--;
                rmax = Math.max(rmax, height[r]);
            }
        }
        return res;
    }
}