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
        int n = lists.length;
        if (n == 0) {
            return null;
        }

        if (n == 1) {
            return lists[0];
        }
        
        if (n == 2) {
            return merge(lists[0], lists[1]);
        }

        int mid = n/2;
        ListNode[] left = new ListNode[mid];
        ListNode[] right = new ListNode[n - mid];

        for (int i=0; i<mid; i++) {
            left[i] = lists[i];
        }

        for (int i=mid; i<n; i++) {
            right[i - mid] = lists[i];
        }

        ListNode left_sorted = mergeKLists(left);
        ListNode right_sorted = mergeKLists(right);
        return merge(left_sorted, right_sorted);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode merged = result;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                merged.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                merged.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            merged = merged.next;
        }

        while (list1 != null) {
            merged.next = new ListNode(list1.val);
            list1 = list1.next;
            merged = merged.next;
        }

        while (list2 != null) {
            merged.next = new ListNode(list2.val);
            list2 = list2.next;
            merged = merged.next;
        }

        return result.next;
    } 
}
