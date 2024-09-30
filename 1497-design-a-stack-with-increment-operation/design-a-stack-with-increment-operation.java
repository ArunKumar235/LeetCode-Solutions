class CustomStack {
    
    int maxSize;
    int[] arr;
    int index = -1;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }
    
    public void push(int x) {
        if(index+1==maxSize) return;
        arr[++index] = x;
    }
    
    public int pop() {
        if(index==-1) return -1;
        return arr[index--];
    }
    
    public void increment(int k, int val) {
        for(int idx = 0; idx<k && idx<=index; idx++){
            arr[idx] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */