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
    Map<String, ListNode> cache = new HashMap<>();
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeRange(lists, 0, lists.length - 1);
    }

    private ListNode mergeRange(ListNode[] lists, int low, int high) {
        String key = low + "," + high;
        if (cache.containsKey(key)) return cache.get(key);

        if (low == high) return lists[low]; // Base case: Single List
        int mid = low + (high - low) / 2;
        ListNode left = mergeRange(lists, low, mid);
        ListNode right = mergeRange(lists, mid + 1, high);

        cache.put(key, mergeTwoLists(left, right));
        return cache.get(key);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode(-1);
        ListNode root = merged;
        
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

        return root.next;
    }
}
