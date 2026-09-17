class Node {
    Node next;
    Node prev;
    int key;
    int value;
    int freq;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
        freq = 1;
    }
}

class DoubleLinkedList {
    Node head;
    Node tail;
    int size;

    DoubleLinkedList() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    void addFirst(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
        size++;
    }

    Node removeLast() {
        if (size == 0) return null;
        Node toRemove = tail.prev;
        if (toRemove == head) return null;
        remove(toRemove);
        return toRemove;
    }

    void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        if (prev != null) prev.next = next;
        if (next != null) next.prev = prev;
        node.next = null;
        node.prev = null; 
        size--;
    }
}

class LFUCache {
    Map<Integer, Node> cache;
    Map<Integer, DoubleLinkedList> frequency;
    int capacity;
    int leastFrequency;

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        frequency = new HashMap<>();
        this.capacity = capacity;
        this.leastFrequency = 1;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        
        Node node = cache.get(key);
        updatefrequency(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            updatefrequency(node);
            return;
        }

        if (cache.size() == capacity) {
            DoubleLinkedList minList = frequency.get(leastFrequency);
            Node removed = minList.removeLast();
            if (removed != null) {
                cache.remove(removed.key);
            }
        }

        Node newnode = new Node(key, value);
        leastFrequency = 1;
        
        frequency.computeIfAbsent(1, k -> new DoubleLinkedList()).addFirst(newnode);
        cache.put(key, newnode);
    }

    private void updatefrequency(Node node) {
        int oldFreq = node.freq;
        DoubleLinkedList dll = frequency.get(oldFreq);
        dll.remove(node);

        if (oldFreq == leastFrequency && dll.size == 0) {
            leastFrequency++;
        }

        node.freq++;
        frequency.computeIfAbsent(node.freq, k -> new DoubleLinkedList()).addFirst(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */