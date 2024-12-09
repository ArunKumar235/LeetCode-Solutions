class Solution {
    int res = Integer.MAX_VALUE;
    
    public int findMinimumTime(List<Integer> strength, int K) {
        permutate(strength, new ArrayList<Integer>(), new boolean[strength.size()], K);
        return res;
    }

    public void permutate(List<Integer> strength, List<Integer> curr, boolean[] visited, int K){
        if(curr.size() == strength.size()){
            calc(curr, K);
            return;
        }
        for(int i = 0; i<strength.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                curr.add(strength.get(i));
                permutate(strength, curr, visited, K);
                curr.remove(curr.size()-1);
                visited[i] = false;
            }
        }
    }

    public void calc(List<Integer> curr, int K){
        int x = 1;
        int time = 0;
        for(int s: curr){
            time += (s+x-1)/x;
            x+=K;
        }
        res = Math.min(res, time);
        return;
    }
}