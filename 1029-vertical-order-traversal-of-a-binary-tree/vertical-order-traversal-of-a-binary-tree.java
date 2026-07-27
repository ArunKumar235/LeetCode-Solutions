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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;

        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(root, 0, 0));

        List<NodeInfo> nodes = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode curr = q.peek().node;
                int row = q.peek().row;
                int col = q.poll().col;
                
                nodes.add(new NodeInfo(row, col, curr.val));

                if(curr.left!=null) q.offer(new Pair(curr.left, row+1, col-1));
                if(curr.right!=null) q.offer(new Pair(curr.right, row+1, col+1));    
            }
        }

        nodes.sort((a, b) -> {
            if(a.col != b.col) return Integer.compare(a.col, b.col);
            if(a.row != b.row) return Integer.compare(a.row, b.row);
            return Integer.compare(a.val, b.val);
        });

        List<Integer> curr = new ArrayList<>();
        int currCol = nodes.get(0).col;
        
        for(NodeInfo node: nodes){
            if(node.col != currCol){
                res.add(curr);
                currCol = node.col;
                curr = new ArrayList<>();
            }
            curr.add(node.val);
        }
        res.add(curr);
        return res;
    }
}

class Pair{
    TreeNode node;
    int row;
    int col;
    Pair(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class NodeInfo{
    int row;
    int col;
    int val;
    NodeInfo(int row, int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}