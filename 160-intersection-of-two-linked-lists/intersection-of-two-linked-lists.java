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
        HashMap<Object, Character> set = new HashMap<>();
        ListNode a = headA;
        ListNode b =  headB;
        while(a!=null && b!=null){
            if(a==b) return a;
            if(set.containsKey(a) && set.get(a)!='a') return a;
            if(set.containsKey(b) && set.get(b)!='b') return b;
            set.put(a, 'a');
            a = a.next;
            set.put(b, 'b');
            b = b.next;
        }
        while(a!=null){
            if(set.containsKey(a) && set.get(a)!='a') return a;
            set.put(a, 'a');
            a = a.next;
        }
        while(b!=null){
            if(set.containsKey(b) && set.get(b)!='b') return b;
            set.put(b, 'b');
            b = b.next;
        }
        return null;
    }
}