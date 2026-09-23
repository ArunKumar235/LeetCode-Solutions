class RangeFreqQuery {
    Map<Integer, List<Integer>> freq = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            if(!freq.containsKey(arr[i])){
                freq.put(arr[i], new ArrayList<>());
            }
            freq.get(arr[i]).add(i);
        }    
    }
    
    public int query(int left, int right, int value) {
        if(!freq.containsKey(value)) return 0;
        
        List<Integer> pos = freq.get(value);

        return upperBound(pos, right) - lowerBound(pos, left);
    }

    private int upperBound(List<Integer> pos, int idx){
        int l = 0;
        int r = pos.size();

        while(l < r){
            int mid = l + (r-l)/2;

            if(pos.get(mid) > idx){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }

    private int lowerBound(List<Integer> pos, int idx){
        int l = 0;
        int r = pos.size();

        while(l < r){
            int mid = l + (r-l)/2;

            if(pos.get(mid) >= idx){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */