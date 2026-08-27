class Node {
    public Node next;
    public int val;
    Node(int val) {
        this.val = val;
        next = null;
    }
}

class MyHashSet {
    private Node[] buckets;
    private int size; 
    public MyHashSet() {
        buckets = new Node[16];
        size = 0;
    }
    
    public void add(int key) {
        // Prevent duplicates entirely
        if (contains(key)) {
            return; 
        }

        int index = getBucketIndex(key, buckets.length);
        Node curr = buckets[index];
        if (curr == null) {
            buckets[index] = new Node(key);
        } else {
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(key);
        }
        size++;
        // Correct the load factor math condition using type casting
        if ((double) size / buckets.length >= 0.7) {
            resize();
        }
    }
    
    public void remove(int key) {
        int index = getBucketIndex(key, buckets.length);
        Node curr = buckets[index];
        Node prev = null;
        if (curr == null) { return; }
        while (curr != null) {
            if (curr.val == key) {
                break;
            }
            prev = curr;
            curr = curr.next;     
        }
        if (prev == null) { buckets[index] = curr.next; }
        else { prev.next = curr == null ? curr : curr.next; }
        size--;
    }
    
    public boolean contains(int key) {
        int index = getBucketIndex(key, buckets.length);
        Node curr = buckets[index];
        while (curr != null) {
            if (curr.val == key) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    private void resize() {
        Node[] oldbuckets = buckets;
        int oldbucketsLength = oldbuckets.length;
        
        // Allocate a fresh, doubled array
        buckets = new Node[oldbucketsLength * 2];
        size = 0; // Reset size because add() will recount the elements

        // Deep copy: Rehash every single element into its correct new index
        for (int i = 0; i < oldbucketsLength; i++) {
            Node curr = oldbuckets[i];
            while (curr != null) {
                add(curr.val); // Calculates the correct updated position
                curr = curr.next;
            }
        }
    }


    private int getBucketIndex(int value, int arraySize) {
        // 1. Convert to a standard positive hash code
        int hashCode = Integer.hashCode(value);
    
        // 2. Clear the sign bit to completely avoid negative index crashes
        int positiveHash = hashCode & 0x7fffffff;

        // 3. Modulo maps the hash safely to a valid array index
        return positiveHash % arraySize;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */