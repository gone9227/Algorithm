package dataStructure.linkedList;

/**
 * x를 기준으로 작은 값은 왼쪽, 큰 값은 오른쪽에 배치
 */
public class LinkedList5 {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.append(9);
        l1.append(1);
        l1.append(4);
        l1.retrieve();

        LinkedList l2 = new LinkedList();
        l2.append(6);
        l2.append(4);
        l2.append(3);
        l2.retrieve();

        LinkedList.Node result = sumLists(l1.getFirst(), l2.getFirst(), 0);
        while (result.next != null){
            System.out.print(result.data + " -> ");
            result = result.next;
        }
        System.out.println(result.data);
    }

    private static LinkedList.Node sumLists(LinkedList.Node l1, LinkedList.Node l2, int carry){
        if(l1 == null && l2 == null && carry == 0){
            return null;
        }

        LinkedList.Node result = new LinkedList.Node();
        int value = carry;

        if(l1 != null){
            value += l1.data;
        }
        if(l2 != null){
            value += l2.data;
        }
        result.data = value % 10;

        if(l1 != null || l2 != null){
            LinkedList.Node next = sumLists(l1 == null ? null : l1.next
                                        , l2 == null ? null : l2.next
                                        , value > 10 ? 1 : 0);
            result.next = next;
        }
        return result;
    }

}

