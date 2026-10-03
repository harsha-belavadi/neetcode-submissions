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

class DoublyLinkedList {
    Map<Integer, Node> cache;
    Node head;
    Node tail;
    int capacity;
    DoublyLinkedList(int capacity, Map<Integer, Node> cache) {
        this.capacity = capacity;
        head = tail = null;
        this.cache = cache;
    }

    public void insertAtHead(int key, int value) {
        if (cache.size() == capacity) {
            removeTail();
        }
        Node newnode = new Node(key, value);
        if (cache.size() == 0) {
            head = tail = newnode;
        } else {
            newnode.next = head;
            head.prev = newnode;
            head = newnode;            
        }
        cache.put(key, newnode);
    }

    public void removeTail() {
        if (tail == null) return;
        Node delete = tail;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        cache.remove(delete.key);
    }

    public void moveToHead(Node node) {
        if (node == head) return;
        
        if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }
        node.prev = node.next = null;
        node.next = head;
        head.prev = node;
        head = node;
    }
}

class LRUCache {
    Map<Integer, Node> cache;
    DoublyLinkedList dll;
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        dll = new DoublyLinkedList(capacity, cache);
    }
    
    public int get(int key) {
        if (cache.size() == 0 || !cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        dll.moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node update = cache.get(key);
            update.value = value;
            dll.moveToHead(update);
            return;
        }

        dll.insertAtHead(key, value);
    }
}
