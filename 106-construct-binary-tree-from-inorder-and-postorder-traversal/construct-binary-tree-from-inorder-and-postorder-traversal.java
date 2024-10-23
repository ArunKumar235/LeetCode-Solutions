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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int startIn, int endIn, int startPost, int endPost){
        if(startIn>endIn || startPost>endPost) return null;
        TreeNode root = new TreeNode(postorder[endPost]);
        int rootIn = -1;
        for(int i = startIn; i<=endIn; i++){
            if(inorder[i]==root.val){
                rootIn = i;
                break;
            }
        }
        int leftTreeSize = rootIn-startIn;

        root.left = build(inorder, postorder, startIn, rootIn-1, startPost, startPost+leftTreeSize-1);
        root.right = build(inorder, postorder, rootIn+1, endIn, startPost+leftTreeSize, endPost-1);

        return root;

    }
}