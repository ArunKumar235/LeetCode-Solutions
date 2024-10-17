class Solution {
    public int maximumSwap(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int n = nums.length;
        
        int left = -1;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                left = i;
                break;
            }
        }
        
        if (left == -1) {
            return num;
        }
        
        int right = left + 1;
        int maxIdx = right;
        for (int i = right; i < n; i++) {
            if (nums[i] >= nums[maxIdx]) {
                maxIdx = i;
            }
        }

        for (int i = 0; i <= left; i++) {
            if (nums[i] < nums[maxIdx]) {
                left = i;
                right = maxIdx;
                break;
            }
        }
        
        char temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        
        return Integer.parseInt(new String(nums));
    }
}
