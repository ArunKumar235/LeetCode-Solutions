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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean reverse = true;
        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> li = new ArrayList<>();
            if(reverse){
                for(int i = 0; i<levelSize; i++){
                    TreeNode curr = q.removeFirst();
                    li.add(curr.val);
                    if(curr.left!=null){
                        q.addLast(curr.left);
                    }
                    if(curr.right!=null){
                        q.addLast(curr.right);
                    }
                }
                reverse = false;
            }else{
                for(int i = 0; i<levelSize; i++){
                    TreeNode curr = q.removeLast();
                    li.add(curr.val);
                    if(curr.right!=null){
                        q.addFirst(curr.right);
                    }
                    if(curr.left!=null){
                        q.addFirst(curr.left);
                    }
                }
                reverse = true;
            }
            list.add(li);
        }
        return list;
    }

}