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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }

        int count = length - n;
        node = head;
        ListNode prev = null;
        while (node != null && count > 0) {
            prev = node;
            node = node.next;
            count--;
        } 

        if (prev == null) head = node.next;
        else prev.next = node.next;

        return head;
    }
}
