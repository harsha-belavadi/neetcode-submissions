public class Node {
    Node next;
    int value;
    Node(int value) {
        next = null;
        this.value = value;
    }
}

public class LinkedList {
    int capacity;
    Node head;
    Node tail;
    int length;
    public LinkedList(int capacity) {
        this.capacity = capacity; 
        length = 0;
        head = tail = null;
    }

    public boolean addLast(int value) {
        if (length == capacity) return false;
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
        if (head == null) return false;
        if (head.next == null) { 
            head = null;
            tail = null;
        }
        else head = head.next;
        length--;
        return true;
    }

    public Node front() {
        return head;
    }

    public Node rear() {
        return tail;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isFull() {
        return length == capacity;
    }
}

class MyCircularQueue {
    LinkedList linkedlist;
    public MyCircularQueue(int k) {
        linkedlist = new LinkedList(k);
    }
    
    public boolean enQueue(int value) {
        return linkedlist.addLast(value);
    }
    
    public boolean deQueue() {
        return linkedlist.removeFirst();
    }
    
    public int Front() {
        Node front = linkedlist.front();
        return front == null ? -1 : front.value;
    }
    
    public int Rear() {
        Node rear = linkedlist.rear();
        return rear == null ? -1 : rear.value;
    }
    
    public boolean isEmpty() {
        return linkedlist.isEmpty();
    }
    
    public boolean isFull() {
        return linkedlist.isFull();
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