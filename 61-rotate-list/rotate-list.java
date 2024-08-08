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
    public ListNode rotateRight(ListNode head, int k) {
        if (k==0) return head;
        if(head==null) return null;
        if(head.next==null) return head;
        int len = 1;
        ListNode tail = head;
        while(tail.next!=null){
            tail = tail.next;
            len++;
        }
        k = k % len;
        if (k==0) return head;
        ListNode prev = null;
        ListNode temp = head;
        while(k!=len){
            prev = temp;
            temp = temp.next;
            len--;
        }
        prev.next = null;
        tail.next = head;
        head = temp;
        return head;
    }
}