class RangeFreqQuery {
    Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
    public RangeFreqQuery(int[] arr) {
        for(int i = 0; i < arr.length;i++){
            map.putIfAbsent(arr[i], new TreeMap<>());
            map.get(arr[i]).put(i, map.get(arr[i]).size());
        }
    }
    
    public int query(int left, int right, int value) {
        if(!map.containsKey(value)) return 0;
        TreeMap<Integer, Integer> nums = map.get(value);
        Integer a = nums.ceilingKey(left), b = nums.floorKey(right);
        if(a == null || b == null) return 0;
        return nums.get(b) - nums.get(a) +1;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */