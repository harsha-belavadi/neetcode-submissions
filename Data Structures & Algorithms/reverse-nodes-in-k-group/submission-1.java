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
        if (head == null || k <= 1) return head;

        // 1. Count total nodes
        int n = 0;        
        ListNode node = head;
        while (node != null) {
            n++;
            node = node.next;
        }

        // 2. Only reverse full k-sized groups (ignore remaining n % k nodes)
        int groups = n / k;
        if (groups == 0) return head;

        // 3. Reverse the first group
        node = head;
        ListNode[] nodes = reverse(node, k);
        head = nodes[0];          // New head of the entire reversed list
        ListNode prevGroupTail = node; // Original head is now the tail of group 1

        // 4. Process remaining groups
        for (int i=2; i<=groups; i++) {
            ListNode nextGroupHead = nodes[1]; // Start of the next group
            nodes = reverse(nextGroupHead, k);
            prevGroupTail.next = nodes[0];     // Connect previous tail to new group head
            prevGroupTail = nextGroupHead;     // Update tail tracker           
        }

        // 5. Connect tail of the last reversed group to the remaining nodes
        prevGroupTail.next = nodes[1];

        return head;
    }

    // Reverses k nodes starting from 'node'
    // Returns array: [newSubListHead, nextSubListStart]
    private ListNode[] reverse(ListNode node, int k) {
        ListNode curr = node;
        ListNode prev = null;
        while (k > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        return new ListNode[] { prev, curr };
    }
}
