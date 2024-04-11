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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null)
            return head;
        if(head.next == null)
            return null;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = new ListNode();

        while(fast.next!=null && fast.next.next!=null) {
            if(fast.next!=null && fast.next.next!=null && fast.next.next.next==null) {
                temp = slow;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast.next == null) {
            temp.next = slow.next;
        }
        if(fast.next != null && fast.next.next == null) {
            slow.next = slow.next.next;
        }

        return head;

    }
}