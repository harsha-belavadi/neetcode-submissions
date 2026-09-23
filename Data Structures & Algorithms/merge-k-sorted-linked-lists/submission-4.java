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
    public ListNode mergeKLists(ListNode[] lists) {
        // Base cases matching your logic
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        if (lists.length == 2) return merge(lists[0], lists[1]);

        int n = lists.length;
        int mid = n / 2;

        // Populate the left sub-array
        ListNode[] left = new ListNode[mid];
        for (int i = 0; i < mid; i++) {
            left[i] = lists[i];
        }

        // Populate the right sub-array
        ListNode[] right = new ListNode[n - mid];
        for (int i = mid; i < n; i++) {
            right[i - mid] = lists[i];
        }

        // Recursively break them down and merge them back up
        ListNode mergedLeft = mergeKLists(left);
        ListNode mergedRight = mergeKLists(right);

        return merge(mergedLeft, mergedRight);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode sorted = new ListNode(-1);
        ListNode curr = sorted;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        while (list1 != null) {
            curr.next = list1;
            list1 = list1.next;
            curr = curr.next;
        }

        while (list2 != null) {
            curr.next = list2;
            list2 = list2.next;
            curr = curr.next;
        }

        return sorted.next;
    }
}
