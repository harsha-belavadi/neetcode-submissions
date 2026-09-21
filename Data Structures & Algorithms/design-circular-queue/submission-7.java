class Node {
    public Node next;
    public int value;
    Node(int value) {
        next = null;
        this.value = value;
    }
}

class LinkedList {
    private Node head;
    private Node tail;
    private int capacity;
    private int length;
    LinkedList(int capacity) {
        this.capacity = capacity;
        length = 0;
        head = tail = null;
    }

    public boolean addLast(int value) {
        if (isFull()) return false;

        Node node = new Node(value);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        length++;
        return true;
    }

    public boolean removeFirst() {
        if (isEmpty()) return false;
        if (head.next == null) {
            head = null;
            tail = null;
        } else head = head.next;
        length--;
        return true;
    }
    
    public int front() {
        if (isEmpty()) return -1;
        return head.value;
    }

    public int rear() {
        if (isEmpty()) return -1;
        return tail.value;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == capacity;
    }
}

class MyCircularQueue {
    private LinkedList linkedList;
    public MyCircularQueue(int k) {
        linkedList = new LinkedList(k);
    }
    
    public boolean enQueue(int value) {
        return linkedList.addLast(value);
    }
    
    public boolean deQueue() {
        return linkedList.removeFirst();
    }
    
    public int Front() {
        return linkedList.front();
    }
    
    public int Rear() {
        return linkedList.rear();
    }
    
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
    
    public boolean isFull() {
        return linkedList.isFull();
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */