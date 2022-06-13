class LinkedList{
    Node header;

    static class Node {
        int data;
        Node next = null;
    }

    LinkedList() {
        header = new Node();
    }

    void append(int d) {
        Node end = new Node();
        end.data = d;
        Node n = header;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    void delete(int d) {
        Node n = header;
        while (n.next != null) {
            if (n.next.data == d){
                n.next = n.next.next;
            }else {
                n = n.next;
            }
        }
    }

    void retrieve() {
        Node n = header.next;
        while (n.next != null){
            System.out.print(n.data);
            n = n.next;
        }
        System.out.print(n.data);
    }
    
    Node get(int d) {
        Node n = header;
        for (int j = 0; j < d; j++)
        {
            n = n.next;
        }
        return n;
    }
}

public class LinkedList_MiddleDelete {
    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ll.retrieve();
    }

    private static boolean deleteNode(Node n){
        if(n == null || n.next == null){
            return false;
        }
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }
}
