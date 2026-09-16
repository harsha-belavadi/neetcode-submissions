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
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }

        curr = head;
        n = count - n; // assume if 6 nodes are there, 
                      // if n == 2, then its 2nd node from last
                      // so count - n = 6 - 2 = 4th node from first
        ListNode prev = null;
        while (curr != null && n > 0) {
            prev = curr;
            curr = curr.next;
            n--;
        } 

        if (prev == null) head = curr.next;
        else prev.next = curr.next;

        return head;
    }
}
