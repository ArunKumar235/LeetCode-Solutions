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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        
        StringBuilder text = new StringBuilder();
        StringBuilder pattern = new StringBuilder();
        
        dfs(root, text);
        dfs(subRoot, pattern);
        return text.toString().contains(pattern.toString());
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }
        sb.append("#").append(node.val).append(",");
        dfs(node.left, sb);
        dfs(node.right, sb);
    }
}