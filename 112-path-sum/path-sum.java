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

    boolean res = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root,0, targetSum);    
        return res;
    }

    public void dfs(TreeNode node, int sum, int ts){
        if(node==null) return;
        if(node.left==null && node.right==null) res = res || (sum+node.val==ts);
        dfs(node.left, sum+node.val, ts);
        dfs(node.right, sum+node.val, ts);
    }
}