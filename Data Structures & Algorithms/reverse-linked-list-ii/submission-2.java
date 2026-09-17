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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode curr = head;
        ListNode prev = null;

        // 1. Traverse to position 'left'
        for (int i = 1; i < left; i++) {
            prev = curr;
            curr = curr.next;
        }

        // Save reconnection points
        ListNode beforeLeft = prev;  // Node at position (left - 1) -> Node 300
        ListNode sublistTail = curr; // Node at position left -> Node 400

        // CRITICAL FIX: Reset prev to null so node 400 doesn't point back to 300
        prev = null;

        // 2. Reverse sublist
        for (int i = 0; i <= right - left; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 3. Reconnect sublist
        sublistTail.next = curr; // 400.next = null (curr is past node 500)

        if (beforeLeft != null) {
            beforeLeft.next = prev; // 300.next = 500
            return head;
        } else {
            return prev;
        }
    }
}