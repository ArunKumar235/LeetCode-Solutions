class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToGroup = new HashMap<>(); // email - groupIdx

        // groupIdx as nodes for union
        UnionFind uf = new UnionFind(accounts.size());

        for(int groupIdx = 0; groupIdx < accounts.size(); groupIdx++){
            for(int i = 1; i<accounts.get(groupIdx).size(); i++){
                String email = accounts.get(groupIdx).get(i);
                
                if(emailToGroup.containsKey(email)){
                    uf.union(emailToGroup.get(email), groupIdx); // union (existing group idx - new group idx)
                }else{
                    emailToGroup.put(email, groupIdx);
                }
            }
        }
        Map<Integer, List<String>> emailGroup = new HashMap<>(); // groupIdx - list of emails

        for(Map.Entry<String, Integer> entry: emailToGroup.entrySet()){
            String email = entry.getKey();
            int groupIdx = entry.getValue();
            int orginalIdx = uf.find(groupIdx);

            emailGroup.putIfAbsent(orginalIdx, new ArrayList<>());
            emailGroup.get(orginalIdx).add(email);
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
}

class UnionFind{
    int n;
    int[] parent;

    UnionFind(int n){
        this.n = n;
        parent = new int[n];
        Arrays.fill(parent, -1);
    }

    public void union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv) return;

        if(parent[pu] <= parent[pv]){
            parent[pu] += parent[pv];
            parent[pv] = pu;
        }else{
            parent[pv] += parent[pu];
            parent[pu] = pv;
        }
    }

    public int find(int u){
        if(parent[u] < 0) return u;
        return parent[u] = find(parent[u]);
    }
}