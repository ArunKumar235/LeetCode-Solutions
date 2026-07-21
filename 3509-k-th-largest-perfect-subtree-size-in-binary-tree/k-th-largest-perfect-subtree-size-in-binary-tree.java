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
    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        dfs(root, pq);

        if (pq.size() < k) return -1;
        while (--k > 0) {
            pq.poll();
        }
        return (1 << pq.peek()) -1;
    }

    public int dfs(TreeNode node, PriorityQueue<Integer> pq){
        if(node==null) return 0;

        int left = dfs(node.left, pq);
        int right = dfs(node.right, pq);
        
        if(left == right && left >= 0) {
            pq.offer(left + 1);
            return left + 1;
        }
        return -1;
    }
}