class Node {
    int val;
    Node prev;
    Node next;

    Node(int val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class MyCircularDeque {
    Node head;
    Node tail;
    int size;
    int capacity;

    public MyCircularDeque(int k) {
        this.size = 0;
        this.capacity = k;
        this.head = null;
        this.tail = null;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) return false;
        
        Node newNode = new Node(value, null, head);
        if (head != null) {
            head.prev = newNode;
        } else {
            tail = newNode;
        }
        head = newNode;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;
        
        Node newNode = new Node(value, tail, null);
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) return false;
        
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;
        
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return true;
    }
    
    public int getFront() {
        return isEmpty() ? -1 : head.val;
    }
    
    public int getRear() {
        return isEmpty() ? -1 : tail.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */