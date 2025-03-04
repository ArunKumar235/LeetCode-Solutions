class Solution {
    public int slidingPuzzle(int[][] board) {
        StringBuilder start = new StringBuilder();
        String target = "123450";  

        int R = 2, C = 3;  

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                start.append(board[row][col]);
            }
        }

        
        int[][] swaparr = {
            {1, 3},    
            {0, 2, 4}, 
            {1, 5},    
            {0, 4},
            {3, 1, 5}, 
            {4, 2}     
        };

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.add(start.toString());
        visited.add(start.toString());

        int swaps = 0;  

        while (!queue.isEmpty()) {
            int qsize = queue.size();

            for (int i = 0; i < qsize; i++) {
                String str = queue.poll();

                if (str.equals(target)) {
                    return swaps;  
                }

                int zeroIdx = str.indexOf('0');  

                for (int swapIdx : swaparr[zeroIdx]) {
                    String swappedStr = swap(str, zeroIdx, swapIdx);
                    
                    if (!visited.contains(swappedStr)) {
                        queue.add(swappedStr);
                        visited.add(swappedStr);
                    }
                }
            }

            swaps++;  
        }

        return -1;  
    }

    
    private String swap(String str, int x, int y) {
        char[] arr = str.toCharArray();
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
        return new String(arr);
    }
}