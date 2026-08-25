class Node {
    public Node next;
    public int val;
    Node(int val) {
        next = null;
        this.val = val;
    }
}

class LinkedList {
    Node head;
    Node tail;
    public LinkedList() {
        head = null;
        tail = null;
    }

    public int get(int index) {
        Node curr = head;
        int i = 0;
        while (curr != null && i < index) {
            curr = curr.next;
            i++;
        }

        if (i < index || curr == null) {
            return -1;
        }

        return curr.val;
    }

    public void insertHead(int val) {
        Node node = new Node(val);
        node.next = head;
        if (head == null) {
            tail = node; // If list was empty, tail is also this node
        }
        head = node;
    }

    public void insertTail(int val) {
        Node node = new Node(val);
        if (head == null) { // If list is empty, both head and tail point to new node
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node; // Move tail to the new end of the list
        }
        tail = node;        
    }

    public boolean remove(int index) {
        Node curr = head;
        Node prev = null;
        int i = 0;
        while (curr != null && i < index) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        if (i < index || curr == null) { return false; }

        if (prev != null) {
            prev.next = curr.next;
        } else {
            head = curr.next;
        }

        // Update tail if we just deleted the tail node
        if (curr == tail) {
            tail = prev;
        }

        curr = null;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        Node curr = head;
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }
        return values;
    }
}
