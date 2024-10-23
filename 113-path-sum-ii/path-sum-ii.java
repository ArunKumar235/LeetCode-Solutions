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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, new ArrayList<>(), targetSum);
        return res;
    }

    public void dfs(TreeNode node, List<Integer> li, int targetSum){
        if(node==null) return;
        if(node.val==targetSum && node.left==null && node.right==null){
            li.add(node.val);
            res.add(new ArrayList<>(li));
            li.remove(li.size()-1);
        }
        li.add(node.val);
        dfs(node.left, li, targetSum-node.val);
        dfs(node.right, li, targetSum-node.val);
        li.remove(li.size()-1);
    }
}