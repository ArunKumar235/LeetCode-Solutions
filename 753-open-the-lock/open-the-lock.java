class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) return 0;

        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if(visited.contains("0000")) return -1;

        Queue<String> q = new ArrayDeque<>();
        q.offer("0000");

        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();
            steps++;
            
            for(int s = 0; s<size; s++){
                String lock = q.poll();
                
                for(int c = 0; c<4; c++){
                    
                    for(int i = -1; i <= 1; i+=2){
                        char[] arr = lock.toCharArray();
                        arr[c] = (char) (((arr[c] - '0' + i + 10) % 10) + '0');
                        
                        String nextLock = new String(arr);
                        
                        if(nextLock.equals(target)) return steps;
                        
                        if(!visited.contains(nextLock)){
                            q.offer(nextLock);
                            visited.add(nextLock);
                        }
                    }
                }
            }
        }
        return -1;
    }
}