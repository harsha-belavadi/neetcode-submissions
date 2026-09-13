class Node {
    Node next;
    int val;
    Node(int val) {
        this.val = val;
        next = null;
    }
}

class MyHashSet {
    Node[] buckets;
    int length;
    public MyHashSet() {
        buckets = new Node[16];
        length = 0;
    }
    
    public void add(int key) {
        if (contains(key)) {
            return;
        }

        int n = buckets.length;
        int index = getBucketIndex(key, n);
        Node curr = buckets[index];
        if (curr == null) {
            buckets[index] = new Node(key);
        } else {
            while (curr != null && curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(key);
        }
        length++;
        if (length > n * 0.75) {
            resize();
        }
    }
    
    public void remove(int key) {
        int n = buckets.length;
        int index = getBucketIndex(key, n);
        Node curr = buckets[index];
        if (curr == null) { return; }
        Node prev = null;
        while (curr != null) {
            if (curr.val == key) {
                if (prev == null) {
                    buckets[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                break;
            }
            prev = curr;
            curr = curr.next;
        }
    }
    
    public boolean contains(int key) {
        int n = buckets.length;
        int index = getBucketIndex(key, n);
        Node curr = buckets[index];
        while (curr != null) {
            if (curr.val == key) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    private int getBucketIndex(int value, int size) {
        int hashcode = Integer.hashCode(value);
        int positiveHash = hashcode & 0x7fffffff;
        return positiveHash % size;
    }

    private void resize() {
        Node[] oldbuckets = buckets;
        int oldbucketsLen = oldbuckets.length;
        buckets = new Node[oldbucketsLen * 2];
        for (int i=0; i<oldbucketsLen; i++) {
            Node curr = oldbuckets[i];
            while (curr != null) {
                add(curr.val);
                curr = curr.next;
            }
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */