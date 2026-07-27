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
    int res = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, new StringBuilder(""));
        return res;
    }
    public void dfs(TreeNode node, StringBuilder sb){
        if(node==null) return;
        if(node.left==null && node.right==null){
            sb.append(node.val);
            res+=Integer.valueOf(sb.toString());
            sb.setLength(sb.length()-1);
        }
        sb.append(node.val);
        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.setLength(sb.length()-1);
    }
}