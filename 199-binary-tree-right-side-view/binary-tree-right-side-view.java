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
        if(root==null) return list;
        dfs(root,1,list);    
        return list;
    }

    public void dfs(TreeNode node, int level, List<Integer> list){
        if(level>maxLevel){
            list.add(node.val);
            maxLevel = level;
        }
        if(node.right!=null) dfs(node.right, level+1, list);
        if(node.left!=null) dfs(node.left, level+1, list);
    }
}