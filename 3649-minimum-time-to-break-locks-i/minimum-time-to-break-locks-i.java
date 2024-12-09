class Solution {
    int res = Integer.MAX_VALUE;
    public int findMinimumTime(List<Integer> strength, int K) {
        boolean[] visited = new boolean[strength.size()];
        permutate(visited, strength, new ArrayList<>(), K);
        return res;
    }
    
    public void permutate(boolean[] visited, List<Integer> s, List<Integer> curr, int k) {
        if(curr.size() == s.size()){
            res = Math.min(res, calc(curr, k));
            return;
        }

        for(int i = 0; i < s.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                curr.add(s.get(i));
                permutate(visited, s, curr, k);
                curr.remove(curr.size() - 1);
                visited[i] = false;
            }
        }
    }
    public int calc(List<Integer> curr, int k){
        int x = 1;
        int time = 0;

        for(int s : curr){
            time += (s+x-1)/x;
            x += k;
        }
        return time;
    }
}