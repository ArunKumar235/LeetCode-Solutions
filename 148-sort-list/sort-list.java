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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right){
        ListNode p1 = left, p2 = right;
        ListNode head = new ListNode();
        ListNode tail = head;
        while(p1!=null && p2!=null){
            if(p1.val<p2.val){
                head.next = p1;
                p1 = p1.next;
            }else{
                head.next = p2;
                p2 = p2.next;
            }
            head = head.next;
        }
        if(p1!=null) head.next = p1;
        if(p2!=null) head.next = p2;
        return tail.next;
    }

    private ListNode getMid(ListNode head){
        ListNode midPrev = null, fast = head;
        while(fast!=null && fast.next!=null){
            midPrev = (midPrev==null) ? head : midPrev.next;
            fast = fast.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
}