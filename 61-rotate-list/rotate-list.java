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
        if(k==0 || head==null || head.next==null) return head;
        int len = 1;
        ListNode tail = head;
        while(tail.next!=null){
            tail = tail.next;
            len++;
        }
        k = k % len;
        if(k==0) return head;
        ListNode temp = head;
        ListNode sl = null;
        while(k<len){
            k++;
            sl = temp;
            temp = temp.next;
        }
        sl.next = null;
        tail.next = head;
        head = temp;
        return head;
    }
}