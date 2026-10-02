class Node {
    Node prev;
    Node next;
    int key;
    int value;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
}

class LinkedList {
    Map<Integer, Node> cache = new HashMap<>();
    Node head;
    Node tail;
    int capacity;
    int length;
    LinkedList(int capacity) {
        this.capacity = capacity;
        head = tail = null;
        length = 0;
    }

    public int get(int key) {
        if (isEmpty() || !cache.containsKey(key)) return -1;
        moveToHead(cache.get(key));
        return cache.get(key).value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node update = cache.get(key);
            update.value = value;
            moveToHead(update);
        } else {
            if (isFull()) {
                removeLast();
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            insertAtHead(newNode);
        }
    }

    private void insertAtHead(Node newNode) {
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    private void removeLast() {
        Node toDelete = tail;
        Node prev = tail.prev;
        if (prev == null) {
            head = tail = null;
        } else {
            prev.next = null;
            tail = prev;
        }
        cache.remove(toDelete.key);
        toDelete.prev = toDelete.next = null;        
        length--;
    }

    private void moveToHead(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        if (prev == null) {
            head = head.next;
        } else if (next == null) {
            prev.next = null;
            tail = prev;
        } else {
            prev.next = next;
            next.prev = prev;
        }
        node.prev = node.next = null;
        length--;
        insertAtHead(node);
    }

    private boolean isFull() {
        return length == capacity;
    }

    private boolean isEmpty() {
        return length == 0;
    }
}

class LRUCache {
    LinkedList linkedList;
    public LRUCache(int capacity) {
        linkedList = new LinkedList(capacity);
    }
    
    public int get(int key) {
        return linkedList.get(key);
    }
    
    public void put(int key, int value) {
        linkedList.put(key, value);
    }
}
