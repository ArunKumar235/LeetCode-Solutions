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

        // values grouped by col -> row -> list of values (sorted)
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode curr = q.peek().node;
                int row = q.peek().row;
                int col = q.poll().col;
                
                map.putIfAbsent(col, new TreeMap<>());
                map.get(col).putIfAbsent(row, new ArrayList<>());
                map.get(col).get(row).add(curr.val);

                if(curr.left!=null) q.offer(new Pair(curr.left, row+1, col-1));
                if(curr.right!=null) q.offer(new Pair(curr.right, row+1, col+1));    
            }
        }
        for(Map.Entry<Integer, Map<Integer, List<Integer>>> entry: map.entrySet()){
            List<Integer> li = new ArrayList<>();
            for(Map.Entry<Integer, List<Integer>> ent: entry.getValue().entrySet()){
                Collections.sort(ent.getValue());
                li.addAll(ent.getValue());
            }
            res.add(li);
        }
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