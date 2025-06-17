class Solution {
    public int minRefuelStops(int target, int curr, int[][] stations) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        int res = 0;
        for( res = 0; curr<target; res++){
            while(idx<stations.length && stations[idx][0] <= curr){
                pq.offer(stations[idx][1]);
                idx++;
            }
            if (pq.isEmpty()) return -1;
            curr += pq.poll();
        }
        return res;
    }
}