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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int v1 = 0;
        int v2 = 0;
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;

        while (l1 != null || l2 != null) {
            v1 = 0;
            v2 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            int nodeval = sum % 10;
            result.next = new ListNode(nodeval);
            result = result.next;
        }

        if (carry > 0) result.next = new ListNode(carry);

        return dummy.next;
    }
}
