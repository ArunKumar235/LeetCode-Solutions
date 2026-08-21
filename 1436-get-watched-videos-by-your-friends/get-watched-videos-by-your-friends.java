class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        boolean[] visited = new boolean[friends.length];
        Queue<Integer> q = new ArrayDeque<>();
        
        q.offer(id);
        visited[id] = true;
        
        int k = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(k == level) break;
            k++;

            for(int i = 0; i<size; i++){
                int u = q.poll();

                for(int v: friends[u]){
                    if(!visited[v]){
                        visited[v] = true;
                        q.offer(v);
                    }
                }
            }
        }

        Map<String, Integer> freq = new HashMap<>();
        
        while(!q.isEmpty()){
            int node = q.poll();
            for(String video: watchedVideos.get(node)) freq.put(video, freq.getOrDefault(video, 0)+1);
        }

        List<Map.Entry<String, Integer>> res = new ArrayList<>(freq.entrySet());
        Collections.sort(res, (a, b) ->{ 
            if(a.getValue() - b.getValue() == 0) return a.getKey().compareTo(b.getKey());
            return a.getValue().compareTo(b.getValue());
        });

        return res.stream()
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }
}