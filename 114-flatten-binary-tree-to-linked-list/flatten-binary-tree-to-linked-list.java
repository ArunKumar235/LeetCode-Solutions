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
    
    public void flatten(TreeNode root) {
        if(root==null) return;
        preorder(root);
        TreeNode travel = q.poll();
        while(!q.isEmpty()){
            travel.left = null;
            travel.right = q.poll();
            travel = travel.right;
        }
        
    }
    Queue<TreeNode> q = new ArrayDeque<>();
    public void preorder(TreeNode node){
        if(node==null) return;
        q.add(node);
        preorder(node.left);
        preorder(node.right);
    }
}