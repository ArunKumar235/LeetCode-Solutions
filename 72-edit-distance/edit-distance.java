class Solution {
    public int minDistance(String a, String b) {
        int l1 = a.length();
        int l2 = b.length();

        int[] prev = new int[l2+1]; 
        int[] curr = new int[l2+1];

        for(int i = 0; i<=l2; i++) prev[i] = i;

        for(int i = 1; i<=l1; i++){
            curr[0] = i;
            for(int j = 1; j<=l2; j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    curr[j] = prev[j-1];
                }else{
                    curr[j] = 1 + Math.min(curr[j-1], Math.min(prev[j], prev[j-1]));
                }
            }
            prev = curr.clone();
        }

        return prev[l2];
    }
}