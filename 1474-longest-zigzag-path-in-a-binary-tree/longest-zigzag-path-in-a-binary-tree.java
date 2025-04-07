/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int longestZigZag(TreeNode root) {
        if(root == null) return 0;
        return Math.max(dfs(root.left, true, 1), dfs(root.right, false, 1));
    }

    private int dfs(TreeNode node, boolean isLeft, int length){
        if(node == null) return length - 1;
        if(isLeft)
            return Math.max(dfs(node.left, true, 1), dfs(node.right, false, length + 1));
        else
            return Math.max(dfs(node.right, false, 1), dfs(node.left, true, length + 1));
    }
}
