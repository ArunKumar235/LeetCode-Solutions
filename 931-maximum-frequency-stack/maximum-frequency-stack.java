class FreqStack {
    // val, freq
    HashMap<Integer, Integer> freq;
    // freq, Stack<val> (to retain the order of elements)
    HashMap<Integer, Stack<Integer>> map;
    int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        map = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        maxFreq = Math.max(maxFreq, f);

        if(!map.containsKey(f)) map.put(f, new Stack<Integer>());
        map.get(f).add(val);    
    }
    
    public int pop() {
        int val = map.get(maxFreq).pop();
        freq.put(val, maxFreq-1);

        if(map.get(maxFreq).size() == 0) maxFreq--;
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */