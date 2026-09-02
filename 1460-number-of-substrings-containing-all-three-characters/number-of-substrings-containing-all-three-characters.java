class Solution {
    public int numberOfSubstrings(String s) {
        int l = 0;
        int n = s.length();

        int[] count = new int[3];
        int letterCount = 0;

        int res = 0;

        for(int r = 0; r < n; r++){
            count[s.charAt(r) - 'a']++;

            if(count[s.charAt(r) - 'a'] == 1) letterCount++;

            while(letterCount == 3){
                res += n - r;

                count[s.charAt(l) - 'a']--;
                
                if(count[s.charAt(l++) - 'a'] == 0) letterCount--;
            }
        }
        return res;
    }
}