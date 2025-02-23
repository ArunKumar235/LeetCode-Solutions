class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {

        PriorityQueue<Integer> res = new PriorityQueue<>();

        for(int i = 0; i<grid.length; i++){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int j = 0; j<grid[i].length; j++){
                if(pq.size() < limits[i]) pq.add(grid[i][j]);
                else{
                    pq.add(grid[i][j]);
                    pq.poll();
                }
            }
            for(int val: pq){
                if(res.size() < k) res.add(val);
                else{
                    res.add(val);
                    res.poll();
                }
            }
        }
        long ans = 0;
        for(int val: res) ans += val;
        return ans;
    }
}