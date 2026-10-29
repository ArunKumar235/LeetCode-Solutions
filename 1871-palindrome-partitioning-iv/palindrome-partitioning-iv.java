class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();

        boolean[][] isPal = new boolean[n][n];

        for(int l = n-1; l >= 0; l--){
            for(int r = l; r < n; r++){
                if(s.charAt(l) == s.charAt(r) && (r-l <= 2 || isPal[l+1][r-1])){
                    isPal[l][r] = true;
                }
            }
        }
        
        for(int i = 0; i < n-1; i++){
            if(!isPal[0][i]) continue;
            for(int j = i + 1; j < n-1; j++){
                if(!isPal[i+1][j] || !isPal[j+1][n-1]) continue;
                return true;
            }
        }
        return false;
    }
}