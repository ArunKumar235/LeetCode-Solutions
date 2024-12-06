class Solution {
    public int singleNonDuplicate(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            
            int mid = left + (right - left) / 2;
            
            if (mid % 2 == 1) {
                mid--;
            }
            
            if (numbers[mid] == numbers[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        
        return numbers[left];
    }
}