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
        if (head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode prevNode = null;
        ListNode currNode = head;
        head = reverse(prevNode, currNode);
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