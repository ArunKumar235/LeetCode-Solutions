class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String str: wordList){
            set.add(str);
        }
        if(!set.contains(endWord)) return 0;

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        int len = 0;

        while(!q.isEmpty()){
            int size = q.size();
            len++;
            for(int i = 0; i<size; i++){
                String str = q.poll();
                char[] curr = str.toCharArray();

                if(str.equals(endWord)) return len;

                for(int j = 0; j<curr.length; j++){
                    char org = curr[j];
                    for(char c = 'a'; c<='z'; c++){
                        if(c==org) continue;

                        curr[j] = c;
                        String next = new String(curr);
                        if(set.contains(next)){
                            q.offer(next);
                            set.remove(next);
                        }
                    }
                    curr[j] = org;
                }
            }
        }
        return 0;
    }
}