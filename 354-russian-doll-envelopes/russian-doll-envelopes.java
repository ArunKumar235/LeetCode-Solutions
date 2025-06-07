class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });

        int n = envelopes.length;
        List<Integer> li = new ArrayList<>();
        li.add(envelopes[0][1]);

        for(int i = 1; i<n; i++){
            if(li.get(li.size()-1) < envelopes[i][1]){
                li.add(envelopes[i][1]);
            }else{
                int idx = binarySearch(li, envelopes[i][1]);
                li.set(idx, envelopes[i][1]);
            }
        }
        return li.size();
    }

    private int binarySearch(List<Integer> li, int val){
        int start = 0;
        int end = li.size()-1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            if(li.get(mid)==val){
                return mid;
            }else if(li.get(mid)<val){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return start;
    }
}