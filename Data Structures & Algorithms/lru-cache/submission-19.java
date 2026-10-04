interface LinkedList {
    public void insert(Node node);
    public void remove(Node node);
    public Node removeTail();
    public void move(Node node);
    public boolean isEmpty();
    public boolean isFull();
}

class Node {
    Node prev;
    Node next;
    int key;
    int value;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
        next = prev = null;
    }
}

class DoublyLinkedList implements LinkedList {
    Node head;
    Node tail;
    int capacity;
    int length;
    DoublyLinkedList(int capacity) {
        head = tail = null;
        this.capacity = capacity;
        length = 0;
    }

    public void insert(Node node) {
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        length++;     
    }

    public void remove(Node node) {
        if (isEmpty()) return;

        if (node == head && node == tail) {
            head = tail = null;
        } else if (node == head) {
            head = head.next;
            head.prev = null;
        } else if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }
        node.next = node.prev = null;
        length--;
    }

    public Node removeTail() {
        Node delete = tail;
        remove(delete);
        return delete;
    }

    public void move(Node node) {
        remove(node);
        insert(node);
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == capacity;
    }
}

class LRUCache {
    Map<Integer, Node> cache;
    LinkedList dll;
    public LRUCache(int capacity) {
        dll = new DoublyLinkedList(capacity);
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        dll.move(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            dll.move(node);
            return;
        }

        if (dll.isFull()) {
            Node deleted = dll.removeTail();
            cache.remove(deleted.key); // evict from cache
        }

        Node newnode = new Node(key, value);
        dll.insert(newnode);
        cache.put(key, newnode);
    }
}
