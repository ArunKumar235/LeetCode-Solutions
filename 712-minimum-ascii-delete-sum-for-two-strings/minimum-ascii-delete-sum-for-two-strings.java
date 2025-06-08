class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] memo = new int[m+1][n+1];
        for(int[] arr: memo){
            Arrays.fill(arr, -1);
        }
        return func(m, n, s1, s2, memo);
    }

    private int func(int i, int j, String s1, String s2, int[][] memo){
        if(i==0 && j==0) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        if(i==0){ 
            int sum = 0;
            while(j!=0){
                sum += s2.charAt(j-1);
                j--;
            }
            return sum;
        }
        if(j==0){ 
            int sum = 0;
            while(i!=0){
                sum += s1.charAt(i-1);
                i--;
            }
            return sum;
        }

        if(s1.charAt(i-1)==s2.charAt(j-1)){
            return memo[i][j] = func(i-1, j-1, s1, s2, memo);
        }
        else{
            return memo[i][j] = Math.min(
                func(i-1, j, s1, s2, memo) + s1.charAt(i-1), 
                func(i, j-1, s1, s2, memo) + s2.charAt(j-1)
            );
        }
    }
}