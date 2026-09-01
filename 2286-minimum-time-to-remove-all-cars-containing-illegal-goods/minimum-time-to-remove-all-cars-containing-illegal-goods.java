class Solution {
    public int minimumTime(String s) {
        int n = s.length();
        
        // minimum cost to clear all illegal goods from s[0] to s[i]
        int left = 0;
        int cost = s.length();

        for(int i = 0; i<n; i++){
            left = Math.min(left + (s.charAt(i) - '0') * 2, i + 1);

            // (n - i - 1) represent the right cost of removing all illegal goods 
            // (continosly not minimum) 
            // if removing from middle is required to find minimum, 
            // left handles it when we reach that index
            cost = Math.min(cost, left + (n - i - 1)); 
        }
        return cost;
    }
}