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
        if(root==null) return 0;
        return Math.max(dfs(root.left, true, 1), dfs(root.right, false, 1));
    }

    private int dfs(TreeNode node, boolean bool, int len){
        if(node==null) return len-1;
        if(bool) return Math.max(dfs(node.right, false, len+1), dfs(node.left, true, 1));
        return Math.max(dfs(node.left, true, len+1), dfs(node.right, false, 1));
    }

}
