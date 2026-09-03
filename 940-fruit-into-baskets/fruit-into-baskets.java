class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int[] freq = new int[n];
        int diff = 0;

        int l = 0;
        int res = 0;
        
        for(int r = 0; r < fruits.length; r++){
            freq[fruits[r]]++;

            if(freq[fruits[r]] == 1) diff++;

            while(diff > 2){
                freq[fruits[l]]--;

                if(freq[fruits[l++]] == 0) diff--;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}