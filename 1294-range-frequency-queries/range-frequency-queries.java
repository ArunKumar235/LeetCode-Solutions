class RangeFreqQuery {
    int[] arr;
    int blockSize;
    List<Map<Integer, Integer>> blocks;

    public RangeFreqQuery(int[] arr) {
        this.arr = arr;

        int n = arr.length;
        blockSize = (int) Math.sqrt(n) + 1;

        int blockCount = (n + blockSize - 1) / blockSize;

        blocks = new ArrayList<>();
        for(int i = 0; i < blockCount; i++) blocks.add(new HashMap<>());

        for(int i = 0; i < n; i++){
            int block = i / blockSize;

            Map<Integer, Integer> freq = blocks.get(block);
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
    }
    
    public int query(int left, int right, int value) {
        int count = 0;

        int leftBlock = left / blockSize;
        int rightBlock = right / blockSize;

        // same block
        if(leftBlock == rightBlock){
            for(int i = left; i <= right; i++){
                if(arr[i] == value){
                    count++;
                }
            }
            return count;
        }

        // left partial block
        int leftEnd = (leftBlock + 1) * blockSize - 1;
        for(int i = left; i <= leftEnd; i++){
            if(arr[i] == value){
                count++;
            }
        }

        // complete blocks
        for(int block = leftBlock + 1; block < rightBlock; block++){
            count += blocks.get(block).getOrDefault(value, 0);
        }

        // right partial block
        int rightStart = rightBlock * blockSize;
        for(int i = rightStart; i <= right; i++){
            if(arr[i] == value){
                count++;
            }
        }

        return count;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */