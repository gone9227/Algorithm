package dataStructure.linkedList;

public class LinkedList1 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.append(5);
        head.retrieve();
        head.delete(1);
        head.retrieve();
    }
}

class Node{
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    void append(int d){
        Node end = new Node(d);
        Node n = this;

        while (n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    void delete(int d){
        Node n = this;
        while (n.next != null){
            if(n.next.data == d){
                n.next = n.next.next;
            }else {
                n = n.next;
            }
        }
    }

    void retrieve(){
        Node n = this;
        while (n.next != null){
            System.out.print(n.data + " => ");
            n = n.next;
        }
        System.out.println(n.data);
    }
}

