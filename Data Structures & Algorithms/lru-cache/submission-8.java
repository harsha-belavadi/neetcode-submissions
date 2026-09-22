class Node {
    private Node next;
    private Node prev;
    private int key;
    private int value;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
    }
}

class DoubleLinkedList {
    Node head;
    Node tail;
    int capacity;
    int length;
    public DoubleLinkedList(int capacity) {
        this.capacity = capacity;
        length = 0;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
        length++;
    }

    public Node removeLast() {
        Node delete = tail.prev;
        Node prev = delete.prev;
        prev.next = tail;
        tail.prev = prev;
        delete.next = delete.prev = null;
        length--;
        return delete;
    }

    public void update(Node node, int value) {
        node.value = value;
        moveToFirst(node);
    }

    public void moveToFirst(Node node) {
        remove(node);
        addFirst(node);
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.next = node.prev = null;
        length--;
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
    DoubleLinkedList dll;
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        dll = new DoubleLinkedList(capacity); 
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        dll.moveToFirst(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            dll.update(node, value);
            return;
        }

        if (dll.isFull()) {
            Node removed = dll.removeLast();
            cache.remove(removed.key);
        }

        Node newnode = new Node(key, value);
        cache.put(key, newnode);
        dll.addFirst(newnode);
    }
}
