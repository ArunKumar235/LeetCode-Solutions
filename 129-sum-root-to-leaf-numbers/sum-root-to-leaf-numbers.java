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
        dfs(root, 0);
        return res;
    }
    public void dfs(TreeNode node, int sum){
        if(node==null) return;
        if(node.left==null && node.right==null){
            res += (sum*10)+node.val;
        }
        sum = sum*10 + node.val;
        dfs(node.left, sum);
        dfs(node.right, sum);
    }
}