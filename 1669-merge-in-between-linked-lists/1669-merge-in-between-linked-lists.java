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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prevA = list1;
        for (int i = 0; i<a-1; i++) {
            prevA = prevA.next;
        }
        
        ListNode curr = prevA.next;

        for (int i = 0; i < b-a+1; i++) {
            curr = curr.next;
        }
        ListNode lastNode = list2;
        while(lastNode.next!=null) {
            lastNode=lastNode.next;
        }
        lastNode.next = curr;
        prevA.next = list2;
        // System.out.println(curr.val);
        return list1;


    }
}