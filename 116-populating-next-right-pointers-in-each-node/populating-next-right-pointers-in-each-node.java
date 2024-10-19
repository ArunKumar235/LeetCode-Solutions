/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Node leftMost = root;
        while(leftMost.left!=null){
            Node travel = leftMost;
            while(travel!=null){
                travel.left.next = travel.right;
                if(travel.next!=null) travel.right.next = travel.next.left;
                travel = travel.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }
}