class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if(x+y==target) return true;
        if(x+y<target) return false;
        if(x%2==0 && y%2==0 && target%2!=0) return false;
        boolean[][] visited = new boolean[x+1][y+1];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int currx = q.peek()[0];
            int curry = q.peek()[1];
            q.poll();
            if(currx==target || curry==target || currx+curry==target) return true;

            if(!visited[0][curry]){
                q.offer(new int[]{0, curry});
                visited[0][curry] = true;
            }
            if(!visited[currx][0]){
                q.offer(new int[]{currx, 0});
                visited[currx][0] = true;
            }
            if(!visited[x][curry]){
                q.offer(new int[]{x, curry});
                visited[x][curry] = true;
            }
            if(!visited[currx][y]){
                q.offer(new int[]{currx, y});
                visited[currx][y] = true;
            }
            if(curry<y){
                int newx = 0;
                int newy = 0;
                if(currx+curry < y){
                    newy = currx+curry;
                }else{
                    newy = y;
                    newx = (curry+currx) - y;
                }
                if(!visited[newx][newy]) q.offer(new int[]{newx, newy});
                visited[newx][newy] = true;
            }
            if(currx<x){
                int newx = 0;
                int newy = 0;
                if(currx+curry < x){
                    newx = currx+curry;
                }else{
                    newx = x;
                    newy = (curry+currx) - x;
                }
                if(!visited[newx][newy]) q.offer(new int[]{newx, newy});
                visited[newx][newy] = true;
            }
            
        }
        return false;
    }
}