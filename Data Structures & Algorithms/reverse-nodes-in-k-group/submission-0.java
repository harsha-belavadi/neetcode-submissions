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
        if (head == null || k == 1) return head;

        // 1. Calculate total length of the list
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // 2. Call reverseLL for each k-group range
        // Ranges: (1, k), (k + 1, 2*k), (2*k + 1, 3*k), ...
        for (int left = 1; left + k - 1 <= length; left += k) {
            int right = left + k - 1;
            head = reverseLL(head, left, right);
        }

        return head;
    }

    private ListNode reverseLL(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode prev = null;
        for (int i=1; i<left; i++) {
            prev = curr;
            curr = curr.next;
        }

        ListNode beforeLeft = prev;
        ListNode sublistTail = curr;

        prev = null;
        for (int i=0; i<=right-left; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        sublistTail.next = curr;
        if (beforeLeft != null) {
            beforeLeft.next = prev;
            return head;
        }
        return prev;
    }
}
