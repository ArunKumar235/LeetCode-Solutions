class Solution {
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        int temp = x;
        int rev = 0;
        while(x>0){   // 121 // 12 // 1
            rev = rev*10 + x%10;   // rev = 0 + 1 // rev = 1 // rev = 10 + 2 = 12 // 120 + 1 // 121
            x/=10; // x = 12  x = 1 // 0
        }
        return rev==temp;
    }
}