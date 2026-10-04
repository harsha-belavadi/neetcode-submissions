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
        ListNode curr = head;
        int n = 0;
        while (curr != null) {
            n++;
            curr = curr.next;
        }

        int groups = n/k;
        curr = head;
        ListNode[] prevAndNext = reverse(curr, k);
        ListNode groupHead = prevAndNext[0];
        ListNode groupTail = curr;

        for (int i=2; i<=groups; i++) {
            ListNode nextGroupHead = prevAndNext[1];
            prevAndNext = reverse(nextGroupHead, k);
            groupTail.next = prevAndNext[0];
            groupTail = nextGroupHead;
        }

        groupTail.next = prevAndNext[1];
        return groupHead;
    }

    private ListNode[] reverse(ListNode node, int k) {
        ListNode prev = null;
        while (k > 0) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
            k--;
        }
        return new ListNode[] { prev, node };
    }
}
