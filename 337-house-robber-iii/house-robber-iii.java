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
    public int rob(TreeNode root) {
        return func(root, new HashMap<>());
    }

    private int func(TreeNode node, Map<TreeNode, Integer> map){
        if(node == null) return 0;
        if(map.containsKey(node)) return map.get(node);

        int val = 0;

        if(node.left != null) val += func(node.left.left, map) + func(node.left.right, map);

        if(node.right != null) val += func(node.right.left, map) + func(node.right.right, map);

        val = Math.max(val + node.val, func(node.left, map) + func(node.right, map));

        map.put(node, val);

        return val;
    }
}