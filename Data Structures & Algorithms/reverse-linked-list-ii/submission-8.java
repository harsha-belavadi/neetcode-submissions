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
        if (head == null) return null;

        int k = right - left;
        
        int index = 1;
        ListNode curr = head;
        ListNode leftListTail = null;
        while (curr != null && index < left) {
            leftListTail = curr;
            curr = curr.next;
            index++;
        }        

        ListNode[] prevAndNext = reverse(curr, k);
        ListNode prev = prevAndNext[0];
        ListNode next = prevAndNext[1];
        
        ListNode reversedTail = curr;
        reversedTail.next = next;

        if (left == 1) {
            head = prev;
        } else {
            leftListTail.next = prev;
        }

        return head;
    }

    private ListNode[] reverse(ListNode node, int k) {
        ListNode prev = null;
        while (k >= 0) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
            k--;
        }
        return new ListNode[] { prev, node };
    }
}