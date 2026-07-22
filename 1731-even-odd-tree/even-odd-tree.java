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
    public boolean isEvenOddTree(TreeNode root) {
        return bfs(root);
    }

    private boolean bfs(TreeNode node){
        if(node==null) return true;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(node);
        boolean sorted = true;

        while(!q.isEmpty()){
            int size = q.size();
            int prev = sorted ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll();
                if(sorted && (curr.val<=prev || curr.val%2 != 1)) return false;
                if(!sorted && (curr.val>=prev || curr.val%2 != 0)) return false;
                
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);

                prev = curr.val;
            }
            sorted = !sorted;
        }
        return true;
    }
}