class Solution {
    Map<String, Integer> emailIdx = new HashMap<>(); // email - idx
    List<String> emails = new ArrayList<>();
    Map<Integer, Integer> emailToGrp = new HashMap<>(); // emailIdx - groupIdx

    List<List<Integer>> adj = new ArrayList<>(); // email as nodes

    boolean[] visited;

    Map<Integer, List<String>> emailGroup = new HashMap<>(); // groupIdx - list of emails

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = 0;
        for(int groupIdx = 0; groupIdx < accounts.size(); groupIdx++){
            for(int i = 1; i<accounts.get(groupIdx).size(); i++){
                String email = accounts.get(groupIdx).get(i);
                if(!emailIdx.containsKey(email)){
                    emailIdx.put(email, n);
                    emails.add(email);
                    emailToGrp.put(n, groupIdx);
                    n++;
                }
            }
        }

        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());
        visited = new boolean[n];

        // emails within same group are connected
        for(int groupIdx = 0; groupIdx < accounts.size(); groupIdx++){
            for(int i = 2; i<accounts.get(groupIdx).size(); i++){
                int u = emailIdx.get(accounts.get(groupIdx).get(i-1));
                int v = emailIdx.get(accounts.get(groupIdx).get(i));

                adj.get(u).add(v);
                adj.get(v).add(u);
            }
        }

        for(int i = 0; i<n; i++){
            if(!visited[i]){
                int groupIdx = emailToGrp.get(i);
                emailGroup.putIfAbsent(groupIdx, new ArrayList<>());
                dfs(i, groupIdx);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry: emailGroup.entrySet()){
            List<String> group = new ArrayList<>();
            group.add(accounts.get(entry.getKey()).get(0));
            Collections.sort(entry.getValue());
            group.addAll(entry.getValue());

            res.add(group);
        }
        return res;
    }

    private void dfs(int email, int groupIdx){
        visited[email] = true;
        emailGroup.get(groupIdx).add(emails.get(email));
        for(int nei: adj.get(email)){
            if(!visited[nei]){
                dfs(nei, groupIdx);
            }
        }
    }
}