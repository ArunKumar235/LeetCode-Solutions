class Solution {
    private int target;
    public int minSteps(int n) {
        if(n==1) return 0;
        this.target = n;
        return 1 + find(1,1);
    }

    public int find(int currLen, int copiedLen){
        if(currLen == this.target) return 0;
        if(currLen>target) return Integer.MAX_VALUE / 2;

        int copyPaste = 2 + find(currLen*2, currLen);
        int pasteOnly = 1 + find(currLen + copiedLen, copiedLen);

        return Math.min(copyPaste, pasteOnly);
    }
}