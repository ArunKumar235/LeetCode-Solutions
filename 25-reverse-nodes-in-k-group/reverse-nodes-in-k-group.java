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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || k==1 ) return head;
        int len = getLength(head);
        int count = len/k;
        ListNode prev = null;
        ListNode curr = head;
        while(count>0){
            ListNode newEnd = curr;
            ListNode last = prev;
            ListNode next = curr.next;
            for(int i = 0; curr!=null && i<k; i++){
                curr.next = prev;
                prev = curr;
                curr = next;
                if(next!=null){
                    next = next.next;
                }
            }
            if(last!=null){
                last.next = prev;
            }else{
                head = prev;
            }
            newEnd.next = curr;
            prev = newEnd;
            count--;
        }
        return head;
    }

    public int getLength(ListNode head){
        int len = 0;
        while(head!=null){
            head = head.next;
            len++;
        }
        return len;
    }
}