class MyHashMap {

    public static class Node {
        private int key;
        private int val;
        private Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            next = null;
        }
    }

    private Node[] buckets;
    private int length;
    public MyHashMap() {
        buckets = new Node[16];
        length = 0;
    }
    
    public void put(int key, int value) {
        int index = getBucketIndex(key, buckets.length);
        Node curr = buckets[index];
        if (curr == null) {
            buckets[index] = new Node(key, value);
        } else {
            Node prev = null;
            while (curr != null) {
                if (curr.key == key) {
                    curr.val = value; // Update existing value - no len increase
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
            prev.next = new Node(key, value);
        }
        length++;
    }
    
    public int get(int key) {
        int index = getBucketIndex(key, buckets.length);
        Node curr = buckets[index];
        if (curr == null) { return -1; }
        else {
            while (curr != null) {
                if (curr.key == key) {
                    return curr.val;
                }
                curr = curr.next;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = getBucketIndex(key, buckets.length);
        Node curr = buckets[index];
        if (curr == null) { return; }
        else {
            Node prev = null;
            while (curr != null) {
                if (curr.key == key) {
                    if (prev == null) { buckets[index] = curr.next; } 
                    else { prev.next = curr.next; }
                    length--;
                    return;
                }
                prev = curr;
                curr = curr.next;
            }            
        }        
    }

    private void resize() {
        Node[] oldbuckets = buckets;
        int oldbucketsLen = oldbuckets.length;
        buckets = new Node[2 * oldbucketsLen];
        for (int i=0; i<oldbucketsLen; i++) {
            Node curr = oldbuckets[i];
            while (curr != null) {
                put(curr.key, curr.val);
                curr = curr.next;
            }
        }
    }

    private int getBucketIndex(int key, int size) {
        // Extract hashcode from integer key
        int hashcode = Integer.hashCode(key);

        // Convert negative hashcode to positive hashcode
        int positiveHashcode = hashcode & 0x7fffffff;

        // Perform modulo on positiveHashcode using bucket size to get index
        return positiveHashcode % size;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */