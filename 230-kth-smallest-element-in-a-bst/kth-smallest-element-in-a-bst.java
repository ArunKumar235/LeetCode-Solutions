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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return inorder(root, k).val;
    }

    private TreeNode inorder(TreeNode node, int k){
        if(node==null) return null;
        
        TreeNode left = inorder(node.left, k);
        if(left!=null) return left;

        count++;
        if(count==k) return node;

        TreeNode right = inorder(node.right, k);
        return right;
    }
}