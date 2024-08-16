class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
        next = null;
    }
}

class MyLinkedList {
    
    public Node head;
    
    public MyLinkedList() {
        head = null;    
    }
    
    public int get(int index) {
        int i = 0;
        Node temp = head;
        while(i<index && temp!=null){
            temp = temp.next;
            i++;
        }
        return temp!=null ? temp.val : -1;
        //return -1;
    }
    
    public void addAtHead(int val) {
        if(head==null){
            head = new Node(val);
        }else{
            Node temp = new Node(val);
            temp.next = head;
            head = temp;
        }
    }
    
    public void addAtTail(int val) {
        if(head==null){
            head = new Node(val);
        }else{
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = new Node(val);
        }
    }
    
    public void addAtIndex(int index, int val) {
        if(index==0){
            Node temp = new Node(val);
            temp.next = head;
            head = temp;
            return;
        }
        int i = 1;
        Node temp = head;
        while(i < index && temp!=null){
            temp = temp.next;
            i++;
        }
        if (temp==null) return;
        Node forw = temp.next;
        temp.next = new Node(val);
        temp.next.next = forw;
    }
    
    public void deleteAtIndex(int index) {
        if(head==null) return;
        if(index==0){
            head = head.next;
            return;
        }
        int i = 1;
        Node temp = head;
        while(i<index && temp!=null){
            temp = temp.next;
            i++;
        }
        if(temp==null || temp.next==null) return;
        temp.next = temp.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
 