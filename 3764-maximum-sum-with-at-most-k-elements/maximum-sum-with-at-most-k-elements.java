class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                pq.add(new int[]{grid[i][j], i});
            }
        }
        long sum = 0;
        while(k!=0){
            int[] arr = pq.poll();
            if(limits[arr[1]]!=0){
                sum+=arr[0];
                limits[arr[1]]--;
                k--;
            }
        }
        return sum;
    }
}