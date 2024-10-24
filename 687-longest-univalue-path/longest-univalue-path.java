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
    int len = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root, -1);
        return len==0 ? 0 : len-1;
    }

    public int dfs(TreeNode node, int val){
        if(node==null) return 0;
        int left = dfs(node.left, node.val);
        int right = dfs(node.right, node.val);

        if(left+right+1 > len){
            len = left+right+1;
        }
        if(val==node.val){
            return Math.max(left, right) + 1;
        }else{
            return 0;
        }
    }
}