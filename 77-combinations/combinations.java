class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> li = new ArrayList<>();
        for(int i = 1; i<(1<<n); i++){
            if(setBits(i)==k){
                List<Integer> l = new ArrayList<>();
                for(int j = 0; j<n; j++){
                    if((i&(1<<j))!=0){
                        l.add(j+1);
                    }
                }
                li.add(l);
            }
        }
        return li;
    }

    public int setBits(int n){
        int count = 0;
        while(n!=0){
            count++;
            n = n&(n-1);
        }
        return count;
    }
}