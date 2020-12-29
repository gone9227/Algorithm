package dataStructure.linkedList;

public class LinkedList2 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ll.retrieve();

//        System.out.println(ll.header.data);
        int k = 4;
//        int i = ll.kthToLast(ll.header, k);
        Reference r = new Reference();
//        LinkedList.Node node = ll.kthToLast(ll.header, k, r);
        LinkedList.Node node = ll.kthToLast(ll.header, k);
        System.out.println(node.data);

    }
}

class Reference{
    public int count = 0;
}

class LinkedList{

    Node header = null;

    static class Node{
        int data;
        Node next = null;

        public Node(){

        }

        public Node(int data){
            this.data = data;
        }
    }

    LinkedList(){
        header = new Node();
    }

    void append(int d){
        Node end = new Node();
        end.data = d;

        Node n = header;
        while (n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    Node getFirst(){
        Node n = header;
        if(header.next != null){
            return header.next;
        }
        return header;
    }

    Node get(int i){
        int idx = 0;
        Node n = getFirst();
        while (n != null){
            if(idx == i) {
                return n;
            }
            n = n.next;
            idx++;
        }
        return null;
    }

    void delete(int d){
        Node n = header;
        while (n.next != null){
            if(n.next.data == d){
                n.next = n.next.next;
            }else {
                n = n.next;
            }
        }
    }

    void retrieve(){
        Node n = header.next;
        while (n.next != null){
            System.out.print(n.data + " => ");
            n = n.next;
        }
        System.out.println(n.data);
    }

    void removeDups(){
        Node n = header;
        while (n != null && n.next != null){
            Node r = n;
            while(r.next != null){
                if(n.data == r.next.data){
                    r.next = r.next.next;
                }else {
                    r = r.next;
                }
            }
            n = n.next;
        }
    }

//    int kthToLast(Node n, int k){
//        if(n == null){
//            return 0;
//        }
//
//        int cnt = kthToLast(n.next, k) + 1;
//        if(cnt == k){
//            System.out.println(k + "th to the last is " + n.data);
//        }
//        return cnt;
//
//    }

    Node kthToLast(Node n, int k, Reference r){
        if(n == null){
            return null;
        }

        Node found = kthToLast(n.next, k, r);
        r.count++;
        if(r.count == k){
            return n;
        }
        return found;

    }

    Node kthToLast(Node first, int k){
        Node p1 = first;
        Node p2 = first;

        for(int i = 0; i < k; i++){
            if(p2 == null) return null;
            p2 = p2.next;
        }

        while (p2 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;

    }

}

