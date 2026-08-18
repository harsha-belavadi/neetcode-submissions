public class Node {
    int key; // When we evict node from tail, we need key to clear it from our cache
    int value;
    Node next;
    Node prev;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
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
        if (!cache.containsKey(key)) { return -1; }
        Node node = cache.get(key);
        remove(node);
        insertAfterHead(node);
        return cache.get(key).value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node replace = cache.get(key);
            remove(replace);
            replace.value = value;
            insertAfterHead(replace);
            cache.put(key, replace);
            return;
        }

        if (cache.size() == capacity) {
            evict();
        }
        
        Node node = new Node(key, value);
        insertAfterHead(node);
        cache.put(key, node);
    }

    private void insertAfterHead(Node node) {
        Node curr = head;
        Node afterHead = curr.next;
        curr.next = node;
        node.next = afterHead;
        node.prev = curr;
        afterHead.prev = node;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void evict() {
        Node toDelete = tail.prev;
        Node prevFromDelete = toDelete.prev;
        prevFromDelete.next = tail;
        tail.prev = prevFromDelete;
        int key = toDelete.key;
        cache.remove(key);
    }
}
