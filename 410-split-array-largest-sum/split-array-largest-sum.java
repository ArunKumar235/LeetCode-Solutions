class Solution {
    public int splitArray(int[] nums, int k) {
        int total = 0;
        int max = 0;
        for(int num: nums){
            max = Math.max(max, num);
            total += num;
        }

        int l = max;
        int r = total;
        while(l < r){
            int mid = l + (r-l)/2;
            if(check(nums, k, mid)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return r;
    }

    private boolean check(int[] nums, int k, int maxSubSum){
        int count = 1;
        int subSum = 0;
        for(int num: nums){
            if(num + subSum > maxSubSum){
                subSum = num;
                count++;
            }else{
                subSum += num;
            }

            if(count > k) return false;
        }
        return true;
    }
}