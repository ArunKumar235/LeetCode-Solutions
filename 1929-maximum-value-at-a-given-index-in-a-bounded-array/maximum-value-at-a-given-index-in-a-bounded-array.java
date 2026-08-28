class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int l = 1;
        int r = maxSum;

        while(l <= r){
            int mid = l + (r-l)/2;
            if(check(n, index, maxSum, mid)){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return r;
    }

    private boolean check(int n, int idx, int maxSum, int peak){
        int leftLen = idx;
        int rightLen = n - idx - 1;

        long total = peak + sideSum(peak, leftLen) + sideSum(peak, rightLen);

        return total <= maxSum;
    }

    // count * (first + last) / 2
    private long sideSum(int peak, int len) {
        if (len == 0) return 0;

        int first = Math.max(peak - len, 1);
        int last = peak - 1;

        int count = last - first + 1;

        long sum = (long) count * (first + last) / 2;

        int remaining = len - count;

        sum += remaining;

        return sum;
    }
}