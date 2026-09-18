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
        ListNode merged = new ListNode(-1);
        ListNode result = merged;

        while (list1 != null && list2 != null) {
            int value = -1;
            if (list1.val <= list2.val) {
                value = list1.val;
                list1 = list1.next;
            } else {
                value = list2.val;
                list2 = list2.next;
            }
            result.next = new ListNode(value);
            result = result.next;
        }

        while (list1 != null) {
            result.next = new ListNode(list1.val);
            list1 = list1.next;
            result = result.next;
        }

        while (list2 != null) {
            result.next = new ListNode(list2.val);
            list2 = list2.next;
            result = result.next;
        }

        return merged.next;
    }
}