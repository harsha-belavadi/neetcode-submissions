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
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        while (second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode first_next = first.next;
            ListNode second_next = second.next;

            first.next = second;
            second.next = first_next;

            first = first_next;
            second = second_next;
        }
    }
}
