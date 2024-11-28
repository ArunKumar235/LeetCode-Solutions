class Solution {
    public int myAtoi(String s) {
        long res = 0;
        int n = s.length();
        boolean pos = true;

        int i = 0;

        while(i<n && s.charAt(i)==' ') i++;

        if(i<n && (s.charAt(i)=='-' || s.charAt(i)=='+')){
            pos = s.charAt(i)=='+';
            i++;
        }

        while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9'){
            res = res*10 + (s.charAt(i)-'0');

            if(pos && res>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(!pos && -res<Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        return (int)(pos ? res : -res);
        
    }
}