class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        int[] dist = new int[n];
        
        Arrays.fill(dist, (int)1e9);
        dist[id] = 0;

        for(int k = 0; k<level; k++){
            for(int u = 0; u<n; u++){
                for(int v: friends[u]){
                    if(dist[u] != (int)1e9 && dist[u] + 1 < dist[v]){
                        dist[v] = dist[u] + 1;
                    }
                    if(dist[v] != (int)1e9 && dist[v] + 1 < dist[u]){
                        dist[u] = dist[v] + 1;
                    }
                }
            }
        }
        Map<String, Integer> freq = new HashMap<>();
        
        for(int i = 0; i<n; i++){
            if(dist[i] == level){
                for(String video: watchedVideos.get(i)) freq.put(video, freq.getOrDefault(video, 0)+1);
            }
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