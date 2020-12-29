package dataStructure.linkedList;

/**
 * x를 기준으로 작은 값은 왼쪽, 큰 값은 오른쪽에 배치
 */
public class LinkedList3 {
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
        LinkedList.Node s1 = null;
        LinkedList.Node e1 = null;
        LinkedList.Node s2 = null;
        LinkedList.Node e2 = null;

        while (n != null){
            LinkedList.Node next = n.next;
            if(n.data < x){
                if(s1 == null){
                    s1 = n;
                    e1 = s1;
                }else {
                    e1.next = n;
                    e1 = n;
                }
            }else {
                if(s2 == null){
                    s2 = n;
                    e2 = s2;
                }else {
                    e2.next = n;
                    e2 = n;
                }
            }
            n = next;
        }
        if(s1 == null){
            return s2;
        }
        e1.next = s2;
        return s1;
    }

}

