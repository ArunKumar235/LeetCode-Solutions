class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for(int num: nums) max = Math.max(max, num);

        int l = 1;
        int r = max;
        while(l < r){
            int mid = l + (r-l)/2;
            if(func(nums, mid, threshold)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean func(int[] nums, int div, int t){
        int divSum = 0;
        for(int num: nums){
            divSum += (num + div - 1) / div;
            if(divSum > t) return false;
        }
        return true;
    }
}