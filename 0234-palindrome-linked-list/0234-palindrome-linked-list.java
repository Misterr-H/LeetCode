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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // here fast pointer is just used to make sure we reach to the middle of linkedList using slow pointer
        ListNode reversed = reverse(slow.next);
        slow.next = null;
        ListNode curr = head;
        while(curr != null && reversed!=null) {
            if (curr.val != reversed.val) {
                return false;
            }
            curr = curr.next;
            reversed = reversed.next;
        }
        return true;
    }

    public ListNode reverse(ListNode list) {
        ListNode prev = null;
        ListNode curr = list;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}