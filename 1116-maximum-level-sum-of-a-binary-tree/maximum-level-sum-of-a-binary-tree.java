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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int maxsum = Integer.MIN_VALUE;
        int level = 1;
        int res = 1;
        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll();
                sum += curr.val;
                if(curr.left !=null) q.add(curr.left);
                if(curr.right !=null) q.add(curr.right);
            }
            if(sum>maxsum){
                maxsum = sum;
                res = level;
            }
            level++;
        }
        return res;
    }
}