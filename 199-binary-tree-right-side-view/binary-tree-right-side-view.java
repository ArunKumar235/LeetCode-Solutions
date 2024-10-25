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
    int maxLevel = 0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, 1, list);
        return list;
    }
    public void dfs(TreeNode root, int level, List<Integer> list){
        if(root==null) return;
        if(level>maxLevel){
            list.add(root.val);
            maxLevel = level;
        }
        dfs(root.right, level+1, list);
        dfs(root.left, level+1, list);
    }

}