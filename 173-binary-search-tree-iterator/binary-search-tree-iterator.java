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
class BSTIterator {
    TreeNode node;
    List<Integer> li = new ArrayList<>();
    int index;
    public BSTIterator(TreeNode root) {
        this.node = root;
        index = 0;
        inorder(root);
    }
    
    public int next() {
        return li.get(index++);
    }
    
    public boolean hasNext() {  
        return index<li.size();
    }

    public void inorder(TreeNode node){
        if(node==null) return;
        inorder(node.left);
        li.add(node.val);
        inorder(node.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */