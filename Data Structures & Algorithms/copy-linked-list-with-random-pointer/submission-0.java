/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> deepcopy = new HashMap<>();
        deepcopy.put(null, null);

        Node curr = head;
        while (curr != null) {
            if (!deepcopy.containsKey(curr)) {
                deepcopy.put(curr, new Node(0));
            }
            deepcopy.get(curr).val = curr.val;

            if (!deepcopy.containsKey(curr.next)) {
                deepcopy.put(curr.next, new Node(0));
            }
            deepcopy.get(curr).next = deepcopy.get(curr.next);

            if (!deepcopy.containsKey(curr.random)) {
                deepcopy.put(curr.random, new Node(0));
            }
            deepcopy.get(curr).random = deepcopy.get(curr.random);

            curr = curr.next;
        }

        return deepcopy.get(head);
    }
}
