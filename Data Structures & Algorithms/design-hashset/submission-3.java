public class MyHashSet {

    public static class Node {
        private final int val;
        private Node next;
        public Node(int val) {
            this.val = val;
            next = null;
        }
    }

    private Node[] buckets;
    private int length;
    public MyHashSet() {
        buckets = new Node[16];
    }

    public void add(int value) {
        if (contains(value)) {
            return;
        }
        int index = getBucketIndex(value, buckets.length);
        Node curr = buckets[index];
        if (curr == null) {
            buckets[index] = new Node(value);
        } else {
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node(value);
        }
        length++;

        if ((double) length/buckets.length >= 0.75) {
            resize();
        }
    }

    public void remove(int value) {
        int index = getBucketIndex(value, buckets.length);
        Node curr = buckets[index];
        if (curr == null) { return; }
        else {
            Node prev = null;
            while (curr != null) {
                if (curr.val == value) {
                    if (prev == null) {
                        buckets[index] = curr.next;
                    } else {
                        prev.next = curr.next;
                    }
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
        }
    }

    public boolean contains(int value) {
        int index = getBucketIndex(value, buckets.length);
        Node curr = buckets[index];
        if (curr == null) { return false; }
        while (curr != null) {
            if (curr.val == value) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    private int getBucketIndex(int value, int size) {
        // Extract hashcode of integer value
        int hashcode = Integer.hashCode(value);

        // Convert hashcode to positive hashcode
        int positiveHashcode = hashcode & 0x7fffffff;

        // Get the index by performing modulo operation using size of buckets
        return  positiveHashcode % size;
    }

    private void resize() {
        Node[] oldBuckets = buckets;
        int oldBucketsLen = oldBuckets.length;
        buckets = new Node[2 * oldBucketsLen];
        for (int i=0; i<oldBucketsLen; i++) {
            Node curr = oldBuckets[i];
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