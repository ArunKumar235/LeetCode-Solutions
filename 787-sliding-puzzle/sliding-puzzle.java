class Solution {
    public int slidingPuzzle(int[][] board) {
        String start = "";
        int R = 2;
        int C = 3;
        for(int i = 0; i<R; i++){
            for(int j = 0; j<C; j++){
                start += board[i][j];
            }
        }
        String target = "123450";

        if(start.equals(target)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(start);
        
        Set<String> visited = new HashSet<>();
        visited.add(start);

        int moves = 1;

        int[][] swaparr = new int[][]{
            {1,3},
            {0,2,4},
            {1,5},
            {0,4},
            {1,3,5},
            {2,4}
        };

        while(!q.isEmpty()){
            int qsize = q.size();

            while(qsize-->0){
                String str = q.poll();
                int idx = str.indexOf("0");

                for(int val: swaparr[idx]){
                    String swappedStr = swap(str.toString(), idx, val);
                    if(!visited.contains(swappedStr)) {
                        q.offer(swappedStr);
                        visited.add(swappedStr);
                    }
                    if(swappedStr.equals(target)) return moves;
                }
            }
            moves++;
        }
        return -1;
    }

    private String swap(String str, int i, int j){
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return new String(arr);
    }
}