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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int startPre, int endPre, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[startPre]);
        int rootIn = -1;

        for (int i = startIn; i <= endIn; i++) {
            if (inorder[i] == root.val) {
                rootIn = i;
                break;
            }
        }

        int leftTreeSize = rootIn - startIn;

        root.left = build(preorder, inorder, startPre + 1, startPre + leftTreeSize, startIn, rootIn - 1);
        root.right = build(preorder, inorder, startPre + leftTreeSize + 1, endPre, rootIn + 1, endIn);

        return root;
    }
}
