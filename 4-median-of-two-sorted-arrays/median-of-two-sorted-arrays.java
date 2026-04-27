class Solution {
    public double findMedianSortedArrays(int[] a, int[] s) {
        int m = a.length;
        int n = s.length;
        // making a the smallest sized array always
        if(m>n) return findMedianSortedArrays(s, a);

        int left = (m+n+1)/2;

        int l = 0;
        int h = m;
        while(l<=h){
            int m1 = l + (h-l)/2;
            int m2 = left-m1;

            int l1 = (m1>0) ? a[m1-1] : Integer.MIN_VALUE;
            int r1 = (m1<m) ? a[m1] : Integer.MAX_VALUE;

            int l2 = (m2>0) ? s[m2-1] : Integer.MIN_VALUE;
            int r2 = (m2<n) ? s[m2] : Integer.MAX_VALUE;

            if(l1 > r2){
                h = m1-1;
            }else if(l2 > r1){
                l = m1+1;
            }else{
                if((m+n) % 2==1) return Math.max(l1,l2);
                return (Math.max(l1,l2)+Math.min(r1,r2))/2.0d;
            }
        }
        return -1;
    }
}