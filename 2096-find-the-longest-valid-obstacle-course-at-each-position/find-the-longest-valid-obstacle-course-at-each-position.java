class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;

        int[] lisLEN = new int[n];
        Arrays.fill(lisLEN, 1);
        
        List<Integer> lis = new ArrayList<>();
        lis.add(obstacles[0]);

        for(int i = 1; i<n; i++){
            if(lis.get(lis.size()-1) <= obstacles[i]){
                
                lis.add(obstacles[i]);
                lisLEN[i] = lis.size();
            
            }else{
                
                int idx = lowerbound(lis, obstacles[i]);
                lis.set(idx, obstacles[i]);
                lisLEN[i] = idx + 1;
           
            }
        }

        return lisLEN;
    }

    // lis = [2, 4, 4, 6] target = 4, op = 3
    // lis = [1, 3, 5, 7] target = 4, op = 2
    private int lowerbound(List<Integer> lis, int target) {
        int left = 0;
        int right = lis.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (lis.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}