interface Queue {
    public boolean enQueue(int value);
    public boolean deQueue();
    public int Front();
    public int Rear();
    public boolean isEmpty();
    public boolean isFull();
}

class Node {
    Node next;
    int value;
    Node(int value) {
        next = null;
        this.value = value;
    }
}

class CircularLinkedList implements Queue {
    Node head;
    Node tail;
    int capacity;
    int length;
    CircularLinkedList(int capacity) {
        this.capacity = capacity;
        length = 0;
    }
    public boolean enQueue(int value) {
        if (isFull()) return false;
        Node newnode = new Node(value);
        if (isEmpty()) {
            head = tail = newnode;
        } else {
            tail.next = newnode;
            tail = newnode;
        }
        tail.next = head;
        length++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        Node delete = head;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        delete.next = null;
        length--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return head.value;
    }

    public int Rear() {
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
    Queue queue;
    public MyCircularQueue(int k) {
        queue = new CircularLinkedList(k);
    }
    
    public boolean enQueue(int value) {
        return queue.enQueue(value);
    }
    
    public boolean deQueue() {
        return queue.deQueue();
    }
    
    public int Front() {
        return queue.Front();
    }
    
    public int Rear() {
        return queue.Rear();
    }
    
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    public boolean isFull() {
        return queue.isFull();
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