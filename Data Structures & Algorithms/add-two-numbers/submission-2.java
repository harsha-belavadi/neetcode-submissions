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
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = 0;
            int v2 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }

            int value = v1 + v2 + carry;
            int nodeValue = value % 10;
            carry = value/10;
            dummy.next = new ListNode(nodeValue);
            dummy = dummy.next;
        }

        if (carry > 0) {
            dummy.next = new ListNode(carry);
        }

        return result.next;
    }
}
