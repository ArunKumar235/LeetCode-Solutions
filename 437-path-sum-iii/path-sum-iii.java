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
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        dfs(root, 0, targetSum,map);
        return count;
    }

    public void dfs(TreeNode node, long prefixSum, int targetSum, HashMap<Long, Integer> map){
        if(node==null) return;
        prefixSum += node.val;
        if(map.containsKey(prefixSum-targetSum)) count += map.get(prefixSum-targetSum);
        if(prefixSum==targetSum) count++;
        map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        dfs(node.left, prefixSum, targetSum, map);
        dfs(node.right, prefixSum, targetSum, map);
        map.put(prefixSum, map.get(prefixSum)-1);
    }
}