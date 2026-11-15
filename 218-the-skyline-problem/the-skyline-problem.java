// https://www.youtube.com/watch?v=GSBLe8cKu0s
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> verticals = new ArrayList<>();

        // transform buildings
        // [x-axis-pos, vertical-height, start(0)/end(1)]
        for(int[] building: buildings){
            verticals.add(new int[]{building[0], building[2], 0});
            verticals.add(new int[]{building[1], building[2], 1});
        }

        // first compare by start
        // if they are same:
        // 1. if both are starts, highest height first
        // 2. if both are ends, lowest height first
        // 3. if one is start and other is end, then start should appear first 
        Collections.sort(verticals, (a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if(a[2] == b[2]){
                if(a[2] == 0) return Integer.compare(b[1], a[1]);
                if(a[2] == 1) return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[2], b[2]);
        });

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(0);

        int prevMax = 0;
        for(int[] vertical : verticals){
            if(vertical[2] == 0) maxHeap.offer(vertical[1]); // vertical in range
            else maxHeap.remove(vertical[1]); // vertical no more in range

            int currMax = maxHeap.peek();

            if(currMax != prevMax){
                res.add(Arrays.asList(vertical[0], currMax));
                prevMax = currMax;
            }
        }
        return res;
    }
}
// TC: O(n) +O(n * (n + logn)) => O(n ^ 2)
// SC: O(n) 