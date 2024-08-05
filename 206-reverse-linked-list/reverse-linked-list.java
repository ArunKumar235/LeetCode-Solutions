/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        head = reverse(null, head);
        return head;
    }

    public ListNode reverse(ListNode prevNode, ListNode currNode){
        if(currNode==null){
            return prevNode;
        }
        ListNode nextNode = currNode.next;
        currNode.next = prevNode;
        return reverse(currNode, nextNode);
    }
}