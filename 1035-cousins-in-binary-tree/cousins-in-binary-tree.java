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
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);
        return (lvlFinder(root,0,xx)==lvlFinder(root,0,yy)) && (!isSibling(root, xx, yy));
    }

    public boolean isSibling(TreeNode parent, TreeNode xx, TreeNode yy){
        if(parent==null) return false;
        return (parent.left==xx && parent.right==yy) || (parent.left==yy && parent.right==xx) || isSibling(parent.left, xx, yy) || isSibling(parent.right, xx, yy);
    }

    public int lvlFinder(TreeNode node, int lvl, TreeNode x){
        if(node==null) return 0;
        if(node==x) return lvl;
        int l = lvlFinder(node.left, lvl+1, x);
        if(l!=0) return l;
        return lvlFinder(node.right, lvl+1, x);
    }

    public TreeNode findNode(TreeNode node, int x){
        if(node==null) return null;
        if(node.val==x) return node;
        TreeNode n = findNode(node.left, x);
        if(n!=null) return n;
        return findNode(node.right, x);
    }
}