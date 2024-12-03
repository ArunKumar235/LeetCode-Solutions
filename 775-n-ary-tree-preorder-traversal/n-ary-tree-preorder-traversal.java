/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> li = new ArrayList<>();
        traverse(root, li);
        return li;
    }
    public void traverse(Node node, List<Integer> li){
        if(node==null) return;
        li.add(node.val);
        for(int i = 0; i<node.children.size(); i++){
            traverse(node.children.get(i), li);
        }
    }
}