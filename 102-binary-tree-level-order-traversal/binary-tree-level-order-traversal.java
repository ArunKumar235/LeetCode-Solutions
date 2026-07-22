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
    public List<List<Integer>> levelOrder(TreeNode root) {
        return bfs(root);
    }

    private List<List<Integer>> bfs(TreeNode node){
        List<List<Integer>> res = new ArrayList<>();
        if(node==null) return res;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(node);
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            
            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll();
                li.add(curr.val);
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            res.add(li);
        }
        return res;
    }
}