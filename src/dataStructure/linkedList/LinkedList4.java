package dataStructure.linkedList;

/**
 * x를 기준으로 작은 값은 왼쪽, 큰 값은 오른쪽에 배치
 */
public class LinkedList4 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(8);
        ll.append(7);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ll.append(1);
        ll.append(2);
        ll.append(5);
        ll.retrieve();
        LinkedList.Node result = partition(ll.getFirst(), 5);
        while (result.next != null){
            System.out.print(result.data + " -> ");
            result = result.next;
        }
        System.out.println(result.data);
    }

    private static LinkedList.Node partition(LinkedList.Node n, int x){
        LinkedList.Node head = n;
        LinkedList.Node tail = n;

        while (n != null){
            LinkedList.Node next = n.next;
            if(n.data < x){
                n.next = head;
                head = n;
            }else {
                tail.next = n;
                tail = n;
            }
            n = next;
        }

        tail.next = null;
        return head;

    }

}

