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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rev = reverse(slow.next);
        slow.next = null;
        ListNode curr = head;
        while(curr!=null && rev!=null) {
            ListNode temp1 = curr.next;
            ListNode temp2 = rev.next;
            curr.next = rev;
            rev.next = temp1;
            rev = temp2;
            curr = temp1;

        }

    }

    public ListNode reverse(ListNode list) {
        ListNode prev = null;
        ListNode curr = list;
        while(curr!=null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}