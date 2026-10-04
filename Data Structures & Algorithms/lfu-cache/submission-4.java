interface LinkedList {
    public void insert(Node node);
    public void remove(Node node);
    public Node removeTail();
    public void move(Node node);
    public boolean isEmpty();
}

class Node {
    Node prev;
    Node next;
    int key;
    int value;
    int frequency;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
        frequency = 1;
        next = prev = null;
    }
}

class DoublyLinkedList implements LinkedList {
    Node head;
    Node tail;
    int length;
    DoublyLinkedList() {
        head = tail = null;
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
}

class LFUCache {
    Map<Integer, LinkedList> frequency;
    Map<Integer, Node> cache;
    int leastFrequency;
    int capacity;
    public LFUCache(int capacity) {
        cache = new HashMap<>();
        frequency = new HashMap<>();
        leastFrequency = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

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

        if (cache.size() == capacity) {
            LinkedList dll = frequency.get(leastFrequency);
            Node node = dll.removeTail();
            cache.remove(node.key);
        }

        leastFrequency = 1;
        Node newnode = new Node(key, value);
        cache.put(key, newnode);
        frequency.computeIfAbsent(leastFrequency, x -> new DoublyLinkedList()).insert(newnode);
    }

    private void updateFrequency(Node node) {
        int oldFrequency = node.frequency;
        LinkedList dll = frequency.get(oldFrequency);
        dll.remove(node);
        if (oldFrequency == leastFrequency && dll.isEmpty()) {
            frequency.remove(oldFrequency);
            leastFrequency++;
        }
        node.frequency++;
        frequency.computeIfAbsent(node.frequency, x -> new DoublyLinkedList()).insert(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */