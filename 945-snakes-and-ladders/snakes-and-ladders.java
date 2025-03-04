class Solution {
    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        int[] arr = new int[(N*N) + 1];
        int idx = 1;
        boolean forward = true;
        for(int i = N-1; i>=0; i--){
            for(int j = 0; j<N; j++){
                if(forward) arr[idx++] = board[i][j];
                else arr[idx++] = board[i][N-j-1];
            }
            forward = !forward;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int[] dist = new int[arr.length];
        Arrays.fill(dist, -1);
        dist[1] = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == N * N) {
                return dist[curr];
            }
            for (int i = 1; i <= 6 && curr + i <= N * N; i++) {
                int next = arr[curr + i] == -1 ? curr + i : arr[curr + i];
                if (dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    queue.offer(next);
                }
            }
        }

        return -1;

    }
}