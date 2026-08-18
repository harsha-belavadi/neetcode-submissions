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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = list1;
        ListNode curr2 = list2;

        ListNode merged = new ListNode(-1);
        ListNode result = merged;
        while (curr1 != null && curr2 != null) {
            if (curr1.val <= curr2.val) {
                merged.next = new ListNode(curr1.val);
                merged = merged.next;
                curr1 = curr1.next;
            } else {
                merged.next = new ListNode(curr2.val);
                merged = merged.next;
                curr2 = curr2.next;
            }
        }

        while (curr1 != null) {
            merged.next = new ListNode(curr1.val);
            merged = merged.next;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            merged.next = new ListNode(curr2.val);
            merged = merged.next;
            curr2 = curr2.next;
        }

        return result.next;
    }
}