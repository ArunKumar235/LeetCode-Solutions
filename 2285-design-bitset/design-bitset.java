class Bitset {
    int n;
    long[] arr;
    int onesCount;
    boolean flipped;

    public Bitset(int size) {
        this.n = size;
        this.arr = new long[(n + 63)/ 64];
        this.onesCount = 0;
        this.flipped = false;
    }
    
    public void fix(int idx) {
        int i = idx / 64;
        int bitIdx = idx % 64;
        long mask = (1L<<bitIdx);

        if(!flipped){
            if((arr[i] & mask) != 0) return;
            arr[i] |= mask;
            onesCount++;
        }else{
            if((arr[i] & mask) == 0) return;
            arr[i] &= ~mask;
            onesCount++;
        }
    }
    
    public void unfix(int idx) {
        int i = idx / 64;
        int bitIdx = idx % 64;
        long mask = (1L<<bitIdx);

        if(!flipped){
            if((arr[i] & mask) == 0) return;
            arr[i] &= ~mask;
            onesCount--;
        }else{
            if((arr[i] & mask) != 0) return;
            arr[i] |= mask;
            onesCount--;
        }
    }
    
    public void flip() {
        flipped = !flipped;
        onesCount = n - onesCount;
    }
    
    public boolean all() {
        return onesCount == n;
    }
    
    public boolean one() {
        return onesCount > 0;
    }
    
    public int count() {
        return onesCount;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            int block = i / 64;
            int bit = i % 64;
            boolean val = ((arr[block] & (1L << bit)) != 0);
            if(flipped){
                val = !val;
            }
            sb.append(val ? '1' : '0');
        }
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */