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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode d = null;
        ListNode o = head;
        ListNode e = head.next;
        ListNode temp = e;
        while(o!=null && o.next!=null){
            d = o;
            o.next = o.next.next;
            o = o.next;
            if(e.next!=null){
                e.next = e.next.next;
                e = e.next;
            }
        }
        if(o!=null) o.next = temp;
        else d.next = temp;
        return head;
    }
}