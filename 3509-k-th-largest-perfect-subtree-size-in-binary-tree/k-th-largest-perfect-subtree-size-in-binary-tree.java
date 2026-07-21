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
        return pq.peek();
    }

    public Pair dfs(TreeNode node, PriorityQueue<Integer> pq){
        if(node==null) return new Pair(0,0,true);;

        Pair left = dfs(node.left, pq);
        Pair right = dfs(node.right, pq);
        
        if(left.perfect && right.perfect && left.height==right.height){
            int size = left.size + right.size + 1;
            pq.offer(size);
            return new Pair(left.height+1,size,true);
        }

        return new Pair(0,0,false);
    }
}

class Pair{
    int height;
    int size;
    boolean perfect;

    Pair(int h, int s, boolean p){
        height = h;
        size = s;
        perfect = p;
    }
}