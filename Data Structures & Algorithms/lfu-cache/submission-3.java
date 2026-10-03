class Node {
    Node prev;
    Node next;
    int key;
    int value;
    int freq;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
        freq = 1;
        prev = null;
        next = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;
    int capacity;
    int length;
    DoublyLinkedList(int capacity) {
        this.capacity = capacity;
        head = tail = null;
        length = 0;
    }

    public void insertAtHead(Node node) {
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;            
        }
        length++;
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
        length--;
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

    public void remove(Node node) {
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

    public boolean isEmpty() {
        return length == 0;
    }
}

class LFUCache {
    Map<Integer, Node> cache;
    Map<Integer, DoublyLinkedList> frequency;
    int leastFrequency;
    int capacity;
    public LFUCache(int capacity) {
        cache = new HashMap<>();
        frequency = new HashMap<>();
        leastFrequency = 1;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (cache.size() == 0 || !cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        updateFrequency(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node update = cache.get(key);
            update.value = value;
            updateFrequency(update);
            return;
        }

        if (cache.size() == capacity) {
            DoublyLinkedList dll = frequency.get(leastFrequency);
            Node node = dll.tail;
            dll.removeTail();
            cache.remove(node.key);
        }

        Node newnode = new Node(key, value);
        leastFrequency = 1;
        frequency.computeIfAbsent(leastFrequency, k -> new DoublyLinkedList(capacity)).insertAtHead(newnode);
        cache.put(key, newnode);
    }

    private void updateFrequency(Node node) {
        int oldFrequency = node.freq;
        DoublyLinkedList dll = frequency.get(oldFrequency);
        dll.remove(node);
        node.freq++;
        if (oldFrequency == leastFrequency && dll.isEmpty()) {
            leastFrequency++;
        }

        frequency.computeIfAbsent(node.freq, k -> new DoublyLinkedList(capacity)).insertAtHead(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */