class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, color, image[sr][sc]);

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int org){
        int R = image.length;
        int C = image[0].length;
        if(sr<0 || sc<0 || sr>=R || sc>=C) return;
        if(image[sr][sc]==color || image[sr][sc]!=org) return;

        image[sr][sc] = color;

        dfs(image, sr+1, sc, color, org);
        dfs(image, sr-1, sc, color, org);
        dfs(image, sr, sc+1, color, org);
        dfs(image, sr, sc-1, color, org);
    }
}