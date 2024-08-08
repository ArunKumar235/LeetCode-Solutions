/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<Object> set = new HashSet<>();
        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }
        while(headB!=null && !set.contains(headB)){
            headB = headB.next;
        }
        return headB;
    }
}