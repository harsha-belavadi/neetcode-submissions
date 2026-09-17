class Node {
    Node next;
    Node prev;
    int key;
    int value;
    Node(int key, int value) { 
        next = null;
        prev = null;
        this.key = key;
        this.value = value; 
    }
}

class LRUCache {
    Map<Integer, Node> cache;
    int capacity;
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
        Node update = replace(cache.get(key));
        addFirst(update);
        return update.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node update = replace(cache.get(key));
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

    private Node addFirst(Node newnode) {
        Node next = head.next;
        head.next = newnode;
        newnode.next = next;
        newnode.prev = head;
        next.prev = newnode;
        return newnode;
    }

    private Node removeLast() {
        Node toRemove = tail.prev;
        if (toRemove == null) return null;

        Node prev = toRemove.prev;
        prev.next = tail;
        tail.prev = prev;
        toRemove.next = null;
        toRemove.prev = null;
        return toRemove;
    }

    private Node replace(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
        node.next = null;
        node.prev = null;
        return node;
    }
}
