// Mo's Algorithm = sqrt-based query ordering + sliding window state reuse.

// SORT queries using blocks
//         ↓
// previous range
//         ↓
// move L/R
//         ↓
// add/remove elements
//         ↓
// new range

// Mo's algorithm sorts queries based on the blocks, 
// with a primary motive of reducing the movements between pointers
// Instead of just always moving l forward, 
// it comporomises l with small backward momevment to achieve significant reduction in r movement

// without Mo's block based sorting, if we just sort by left right values
// [0, 999]
// [1, 1]
// [2, 998]
// [3, 3]
// [4, 997]
// in this case we would have to do huge reset for r values evertime

// with block based sorting n = 1000, sqrt = 32
// [1, 1]
// [3, 3]
// [4, 997]
// [2, 998]
// [0, 999]

// with zig-zag sorting
// (r pointer movement)
// Block 0: 10 → 500 → 900 → 1000
//              ↓ small
// Block 1: 990 → 800 → 400 → 20
//              ↓ small
// Block 2: 30 → 300 → 700 → 1000


class Solution{
    int[] freq;
    int unique = 0;
    int oddFreqCount = 0;

    public boolean[] validSubarrays(int[] nums, int k, int[][] queries){
        int n = nums.length;
        int blockSize = (int) Math.ceil(Math.sqrt(n));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int blockA = a[0] / blockSize;
            int blockB = b[0] / blockSize;

            if(blockA != blockB) return Integer.compare(blockA, blockB);

            // Alternate R direction between blocks (zig-zag ordering)
            if(blockA % 2 == 1) return Integer.compare(a[1], b[1]);

            return Integer.compare(b[1], a[1]);
        });

        for(int i = 0; i < queries.length; i++){
            pq.offer(new int[]{queries[i][0], queries[i][1], i});
        }

        int max = 0;
        for(int num : nums) max = Math.max(max, num);

        freq = new int[max + 1];

        boolean[] ans = new boolean[queries.length];

        int currL = 0;
        int currR = -1;

        while(!pq.isEmpty()){
            int[] query = pq.poll();

            int l = query[0];
            int r = query[1];
            int idx = query[2];

            while(currL > l){
                currL--;
                add(nums[currL]);
            }

            while(currR < r){
                currR++;
                add(nums[currR]);
            }

            while(currL < l){
                remove(nums[currL]);
                currL++;
            }

            while(currR > r){
                remove(nums[currR]);
                currR--;
            }

            ans[idx] = unique == k && oddFreqCount == 0;
        }
        return ans;
    }

    private void add(int num){
        if(freq[num] == 0) unique++;

        if(freq[num] % 2 == 0) oddFreqCount++;
        else oddFreqCount--;
        
        freq[num]++;
    }

    private void remove(int num){
        freq[num]--;

        if(freq[num] % 2 == 0) oddFreqCount--;
        else oddFreqCount++;

        if(freq[num] == 0) unique--;
    }
}