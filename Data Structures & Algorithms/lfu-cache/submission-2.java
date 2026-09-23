class Node {
    Node next;
    Node prev;
    int key;
    int value;
    int frequency;
    Node (int key, int value) {
        this.key = key;
        this.value = value;
        frequency = 1;
        next = null;
        prev = null;
    }
}

class DoubleLinkedList {
    Node head;
    Node tail;
    int capacity;
    int length;
    DoubleLinkedList(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node node) {
        if (isFull()) removeLast();

        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
        length++;
    }

    public Node removeLast() {
        if (isEmpty()) return null;

        Node delete = tail.prev;
        if (delete == head) return null;
        Node prev = delete.prev;
        prev.next = tail;
        tail.prev = prev;
        length--;
        
        return delete;
    }

    public void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
        length--;
    }

    public void moveToFirst(Node node) {
        remove(node);
        addFirst(node);
    }

    public void update(Node node, int value) {
        node.value = value;
        moveToFirst(node);
    }

    public boolean isFull() {
        return length == capacity;
    }

    public boolean isEmpty() {
        return length == 0;
    }
}

class LFUCache {
    Map<Integer, Node> cache;
    Map<Integer, DoubleLinkedList> frequency;
    int leastFrequency = 0;
    int capacity;
    public LFUCache(int capacity) {
        cache = new HashMap<>();
        frequency = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        updateFrequency(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }

        // Cache is full: evict LFU item (least recent among least frequent)
        if (cache.size() == capacity) {
            DoubleLinkedList lfuList = frequency.get(leastFrequency);
            Node evicted = lfuList.removeLast();
            if (evicted != null) {
                cache.remove(evicted.key);
            }
        }

        Node newnode = new Node(key, value);
        cache.put(key, newnode);
        frequency.computeIfAbsent(1, k -> new DoubleLinkedList(capacity)).addFirst(newnode);
        leastFrequency = 1;
        updateFrequency(newnode);
    }

    private void updateFrequency(Node node) {
        int oldcount = node.frequency;
        DoubleLinkedList dll = frequency.get(oldcount);
        dll.remove(node);

        if (oldcount == leastFrequency && dll.isEmpty()) {
            leastFrequency++;
        }

        node.frequency++;
        int count = node.frequency;
        frequency.computeIfAbsent(count, k -> new DoubleLinkedList(capacity)).addFirst(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */