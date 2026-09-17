class Node {
    Node next;
    Node prev;
    int key;
    int value;

    Node(int key, int value) {
        this.value = value;
        this.key = key;
        next = null;
        prev = null;
    }
}

class LRUCache {
    private Map<Integer, Node> cache;
    private int capacity;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        node = replace(node);
        node = addFirst(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node update = cache.get(key);
            update = replace(update);
            update.value = value;
            addFirst(update);
            return;
        }
        Node newnode = new Node(key, value);
        cache.put(key, addFirst(newnode));

        if (cache.size() > capacity) {
            Node removed = removeLast();
            cache.remove(removed.key);
        }
    }

    private Node addFirst(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
        return node;
    }

    private Node removeLast() {
        Node toRemove = tail.prev;
        if (toRemove == head) return null;
        Node prev = toRemove.prev;
        prev.next = tail;
        tail.prev = prev;
        toRemove.next = null;
        toRemove.prev = null;
        return toRemove;
    }

    private Node replace(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
        return node;
    }
}
